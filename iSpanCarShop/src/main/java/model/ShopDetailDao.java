package model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

public class ShopDetailDao {

	DataSource ds = null;

	public ShopDetailDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/SHOP_DETAIL_DB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public java.sql.Date stringToSqlDate(String string) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date udate = df.parse(string);
		java.sql.Date update = new java.sql.Date(udate.getTime());
		return update;
	}

	public Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

	public String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	// 拿所有產品資料，回傳List<Member>
	public List<ShopDetailBean> findAllProduct() throws SQLException {
		String sql = "select * from SHOP_DETAIL";

		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);

		ResultSet rs = preState.executeQuery();

		List<ShopDetailBean> list = new ArrayList<>();

		while (rs.next()) {
			ShopDetailBean sdb = new ShopDetailBean();

			sdb.setProductno(rs.getInt("productno"));
			sdb.setProductname(rs.getString("productname"));
			sdb.setType(rs.getString("type"));
			sdb.setSpec(rs.getString("spec"));
			sdb.setPrice(rs.getInt("price"));
			sdb.setStock(rs.getInt("stock"));
			sdb.setSpec(rs.getString("spec"));
			sdb.setUptime(rs.getString("uptime"));
			sdb.setProductinfo(rs.getString("productinfo"));
			sdb.setProductimage(rs.getBlob("productimage"));
			sdb.setProductimage_name(rs.getString("productimage_name"));
			list.add(sdb);
		}
		// 回傳list
		rs.close();
		preState.close();
		return list;
	}

	// 新增資料
	public void insertProduct(ShopDetailBean sdb) throws SQLException {
		String sql = "insert into SHOP_DETAIL(productname,type,spec,price,stock,uptime,productinfo,productimage,productimage_name) values (?,?,?,?,?,?,?,?,?)";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, sdb.getProductname());
		preState.setString(2, sdb.getType());
		preState.setString(3, sdb.getSpec());
		preState.setInt(4, sdb.getPrice());
		preState.setInt(5, sdb.getStock());
		java.sql.Date uptime = null;
		try {
			uptime = stringToSqlDate(sdb.getUptime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		preState.setDate(6, uptime);
		preState.setString(7, sdb.getProductinfo());
		preState.setBinaryStream(8, sdb.getProductimage().getBinaryStream());
		preState.setString(9, sdb.getProductimage_name());
		int row = preState.executeUpdate();
		System.out.println("新增了" + row + "筆");
		preState.close();
	}

	// 透過productno拿資料
	public List<ShopDetailBean> findByProductno(String productno) throws SQLException {
		String sql = "select * from SHOP_DETAIL where productno = ?";

		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, productno);

		ResultSet rs = preState.executeQuery();

		List<ShopDetailBean> list = new ArrayList<>();

		while (rs.next()) {
			ShopDetailBean sdb = new ShopDetailBean();

			sdb.setProductno(rs.getInt("productno"));
			sdb.setProductname(rs.getString("productname"));
			sdb.setType(rs.getString("type"));
			sdb.setSpec(rs.getString("spec"));
			sdb.setPrice(rs.getInt("price"));
			sdb.setStock(rs.getInt("stock"));
			sdb.setSpec(rs.getString("spec"));
			sdb.setUptime(rs.getString("uptime"));
			sdb.setProductinfo(rs.getString("productinfo"));
			sdb.setProductimage(rs.getBlob("productimage"));
			sdb.setProductimage_name(rs.getString("productimage_name"));
			list.add(sdb);
		}
		// 回傳list
		rs.close();
		preState.close();
		return list;
	}

	// 修改一筆產品資料
//	public void updateProduct(ShopDetailBean sdb) {
//		String sql = "UPDATE SHOP_DETAIL SET " + " productname=?,  type=?,  spec=?, price = ?, stock = ?, "
//				+ " uptime=?, productinfo=?,productimage=?,productimage_name=? where productno=?";
//	
//		try {
//			Connection conn = ds.getConnection();
//			PreparedStatement preState = conn.prepareStatement(sql);
//			{
//				preState.setString(1, sdb.getProductname());
//				preState.setString(2, sdb.getType());
//				preState.setString(3, sdb.getSpec());
//				preState.setInt(4, sdb.getPrice());
//				preState.setInt(5, sdb.getStock());
//				java.sql.Date uptime = null;
//				uptime = stringToSqlDate(sdb.getUptime());
//				preState.setDate(6, uptime);
//				preState.setString(7, sdb.getProductinfo());
//				preState.setBinaryStream(8, sdb.getProductimage().getBinaryStream());
//				preState.setString(9, sdb.getProductimage_name());
//				int row = preState.executeUpdate();
//				System.out.println("修改了" + row + "筆");
//				preState.close();
//			}
//		} catch (SQLException | ParseException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("ShopDetailDao()#updateProduct(BookBean)發生例外: " + ex.getMessage());
//		}
//	}
		// 修改一筆產品資料
	public void updateProduct(ShopDetailBean sdb) {
		String sql = "update SHOP_DETAIL SET productname = ? , price = ? ,stock = ? ,productinfo = ? ,productimage = ? ,productimage_name = ? where productno = ?";
		try {
			Connection conn = ds.getConnection();
			PreparedStatement preState = conn.prepareStatement(sql);
			{
				preState.setString(1, sdb.getProductname());
				preState.setInt(2, sdb.getPrice());
				preState.setInt(3, sdb.getStock());
				preState.setInt(7, sdb.getProductno());
//				preState.setString(3, sdb.getSpec());
//				java.sql.Date uptime = null;
//				uptime = stringToSqlDate(sdb.getUptime());
//				preState.setDate(6, uptime);
				preState.setString(4, sdb.getProductinfo());
				preState.setBinaryStream(5, sdb.getProductimage().getBinaryStream());
				preState.setString(6, sdb.getProductimage_name());
				int row = preState.executeUpdate();
				System.out.println("修改了" + row + "筆");
				preState.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("ShopDetailDao()#updateProduct(BookBean)發生例外: " + ex.getMessage());
		}
	}

	// 刪除該產品 用productno找
	public void deleteProduct(ShopDetailBean sdb) throws SQLException {
		String sql = "delete from SHOP_DETAIL where productno = ?";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, sdb.getProductno());
		preState.executeUpdate();
		System.out.println("已刪除該產品!");
		preState.close();
		conn.close();

	}

}
