package member;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
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
	
	public Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}
	
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
	
	public String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	
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
		
		preparedStatement.setBinaryStream(10, bean.getFile().getBinaryStream());
		preparedStatement.setString(11, bean.getFilename());
		
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		conn.close();
	}
	
}
