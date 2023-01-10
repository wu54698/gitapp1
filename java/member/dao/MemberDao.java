package member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

import member.model.MemberBean;


public class MemberDao {

	DataSource ds = null;
	public MemberDao() {//連線物件
		try{
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/iSpan_car_DataBase");//連到context.xml > java:comp/env/name
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public java.sql.Date stringToSqlDate(String string) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date udate = df.parse(string);
		java.sql.Date sdate = new java.sql.Date(udate.getTime());
		return sdate;
	}
	//inputstream ->blob
	public Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}
	//用帳號找資料
	public List<MemberBean> findbyaccountnumber(String accountnumber) throws SQLException{
		String sql ="select * from member where accountnumber = ? ";
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		List<MemberBean> list = new ArrayList<>();
		preparedStatement.setString(1, accountnumber);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			MemberBean mb = new MemberBean();
			mb.setAccountnumber(rs.getString("accountnumber"));
			mb.setMemberpassword(rs.getString("memberpassword"));
			mb.setMemberName(rs.getString("membername"));
			mb.setPhonenumber(Integer.toString(rs.getInt("phonenumber")) );
			mb.setEmail(rs.getString("email"));
			mb.setMemberaddress(rs.getString("memberaddress"));
			mb.setPlatenumber(rs.getString("platenumber"));
			mb.setBirthday(rs.getString("birthday"));
			mb.setIdnumber(rs.getString("idnumber"));
			mb.setFile(rs.getBlob("personalimg"));
			mb.setFilename(rs.getString("imgfilename"));
			list.add(mb);
		}	
			rs.close();
			preparedStatement.close();
			conn.close();
			return list;
	}
	//用帳號找資料不含圖
	public List<MemberBean> findbyaccountnumberwithoutimage(String accountnumber) throws SQLException{
		String sql ="select * from member where accountnumber = ? ";
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		List<MemberBean> list = new ArrayList<>();
		preparedStatement.setString(1, accountnumber);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			MemberBean mb = new MemberBean();
			mb.setAccountnumber(rs.getString("accountnumber"));
			mb.setMemberpassword(rs.getString("memberpassword"));
			mb.setMemberName(rs.getString("membername"));
			mb.setPhonenumber(Integer.toString(rs.getInt("phonenumber")) );
			mb.setEmail(rs.getString("email"));
			mb.setMemberaddress(rs.getString("memberaddress"));
			mb.setPlatenumber(rs.getString("platenumber"));
			mb.setBirthday(rs.getString("birthday"));
			mb.setIdnumber(rs.getString("idnumber"));
			list.add(mb);
		}	
		rs.close();
		preparedStatement.close();
		conn.close();
		return list;
	}
	//取得檔名
	public String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	//放入資料庫
	public void insertMemberBean(MemberBean bean) throws SQLException, ParseException {
		
		String sql ="insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn =ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		
		preparedStatement.setString(1, bean.getAccountnumber());
		preparedStatement.setString(2, bean.getMemberpassword());
		preparedStatement.setString(3, bean.getMemberName());
		int phone = Integer.parseInt(bean.getPhonenumber());
		preparedStatement.setInt(4,phone);
		preparedStatement.setString(5, bean.getEmail());
		preparedStatement.setString(6, bean.getMemberaddress());
		preparedStatement.setString(7, bean.getPlatenumber());
		java.sql.Date birthday = stringToSqlDate(bean.getBirthday());
		preparedStatement.setDate(8, birthday);
		preparedStatement.setString(9, bean.getIdnumber());
		preparedStatement.setBlob(10, bean.getFile());
		preparedStatement.setString(11, bean.getFilename());
		
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		conn.close();
	}
	
	//用帳號刪除資料
	public int deleteByAccountnumber(String accountnumber) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "Delete From member where accountnumber = ?" ;
		
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1,accountnumber);

		int row = preState.executeUpdate();
		preState.close();
		conn.close();
		//System.out.println("刪除" + row + "筆資料");
		return row;
	}
	//用帳號修改車牌
	public void updateByAccountnumber(MemberBean mb) throws SQLException, ParseException {
		Connection conn = ds.getConnection();
		String sql = "Update member set memberpassword = ?,memberName= ?,phonenumber= ?"
				+ ",email = ?,memberaddress = ?, platenumber = ?,birthday = ?"
				+ ",idnumber = ? where accountnumber = ?";
		
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, mb.getMemberpassword());
		preState.setString(2, mb.getMemberName());
		int phone = Integer.parseInt(mb.getPhonenumber());
		preState.setInt(3,phone);
		preState.setString(4, mb.getEmail());
		preState.setString(5, mb.getMemberaddress());
		preState.setString(6, mb.getPlatenumber());
		java.sql.Date birthday = stringToSqlDate(mb.getBirthday());
		preState.setDate(7, birthday);
		preState.setString(8, mb.getIdnumber());
		
		preState.setString(9, mb.getAccountnumber());
		
		preState.executeUpdate();
		preState.close();
		conn.close();
		
		
	}
	public boolean checkaccountnumber(String accountnumber) throws SQLException{
		String sql ="select * from member where accountnumber = ? ";
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, accountnumber);
		ResultSet rs = preparedStatement.executeQuery();
		boolean check = false;
		if(rs.next()) {
			check = true;
		}
		
			rs.close();
			preparedStatement.close();
			conn.close();
			return check;
		
	}
	
	public String checkaccountnumberpassword(String accountnumber,String password) throws SQLException{
		String sql ="select memberpassword from member where accountnumber = ? ";
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, accountnumber);
		ResultSet rs = preparedStatement.executeQuery();
		String psw ="";
		if(	rs.next()) {
			psw  =  rs.getString("memberpassword");
			if(psw.trim().equals(password.trim())) {
				psw ="資料正確";
			}else {
				psw = "資料有誤";
			}
		}else {
			psw = "無資料";
		}

		
		rs.close();
		preparedStatement.close();
		conn.close();
		return psw;
		
	}
	
	public List<MemberBean> selectAll() throws SQLException{
		String sql ="select * from member ";
		List<MemberBean> list = new ArrayList<>();
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			MemberBean mb = new MemberBean();
			mb.setAccountnumber(rs.getString("accountnumber"));
			mb.setMemberpassword(rs.getString("memberpassword"));
			mb.setMemberName(rs.getString("membername"));
			mb.setPhonenumber(Integer.toString(rs.getInt("phonenumber")) );
			mb.setEmail(rs.getString("email"));
			mb.setMemberaddress(rs.getString("memberaddress"));
			mb.setPlatenumber(rs.getString("platenumber"));
			mb.setBirthday(rs.getString("birthday"));
			mb.setIdnumber(rs.getString("idnumber"));
			mb.setFile(rs.getBlob("personalimg"));
			mb.setFilename(rs.getString("imgfilename"));
			list.add(mb);
		}	
		rs.close();
		preparedStatement.close();
		conn.close();
		return list;
	}
	
}
