package ispan_cart;

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
import javax.sql.DataSource;

public class CartDao {

	DataSource ds = null;

	public CartDao() {// 連線物件
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/iSpan_car_DataBase");// 連到context.xml > java:comp/env/name
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public java.sql.Date stringToSqlDate(String string) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date udate = df.parse(string);
		java.sql.Date sdate = new java.sql.Date(udate.getTime());
		return sdate;
	}

	public List<CartBean> findAllById(String memberId) throws SQLException {
		List<CartBean> list = new ArrayList<>();
		Connection conn = ds.getConnection();
		String sql = "select * from cart where memberId = ? ";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, memberId);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
//				CartBean cb = new CartBean();

//				cb.setproductNumber(rs.getString("productNumber"));
//				cb.setproductName(rs.getString("productName"));
//				cb.setProductPrice(rs.getString("productPrice"));
//				cb.setquantity(rs.getString("quantity"));
			CartBean cart = new CartBean(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			list.add(cart);

		}

		rs.close();
		preparedStatement.close();
		conn.close();
		return list;
	}

	public List<CartBean> findAllCart() throws Exception {

		List<CartBean> allCart = new ArrayList<CartBean>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * from  cart");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				CartBean cart = new CartBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				allCart.add(cart);
			}
		}
		return allCart;
	}

	public void insertCartBean(CartBean bean) throws SQLException, ParseException {

		String sql = "insert into cart values(?,?,?,?,?)";

		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.setString(1, bean.getmemberId());
		preparedStatement.setString(2, bean.getproductNumber());
		preparedStatement.setString(3, bean.getproductName());
		preparedStatement.setString(4, bean.getProductPrice());
		preparedStatement.setString(5, bean.getquantity());

		preparedStatement.executeUpdate();
		preparedStatement.close();
		conn.close();
	}

	public void deletecartId(String cartId) throws SQLException, ParseException {

		String sql = "DELETE FROM cart WHERE cartId  =?";
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, cartId);

		preparedStatement.executeUpdate();
		System.out.println("OK");
		preparedStatement.close();
		conn.close();
	}

	public void deletecartByMemberId(String memberId) throws SQLException, ParseException {

		String sql = "DELETE FROM cart WHERE memberId   =?";
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, memberId);

		preparedStatement.executeUpdate();
		System.out.println("OK");
		preparedStatement.close();
		conn.close();
	}

	public void updateQuantityByCartId(String quantity, String cartId) throws SQLException, ParseException {

		String sql = "UPDATE cart SET quantity =? WHERE cartid=?;";
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, quantity);
		preparedStatement.setString(2, cartId);
		System.out.println("OK");

		preparedStatement.executeUpdate();
		preparedStatement.close();
		conn.close();
	}
	
	
	
}
