package ispan_order;

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





public class OrderDao {

	DataSource ds = null;

	public OrderDao() {// 連線物件
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/iSpan_car_DataBase");// 連到context.xml > java:comp/env/name
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public java.sql.Timestamp stringToSqlDate() throws ParseException {
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		java.sql.Timestamp sdate = new java.sql.Timestamp(date.getTime());
		return sdate;
	}
	
	

	
	public void insertOrderBean(OrderBean bean) throws SQLException, ParseException {
		
		String addsql = "insert into orders (orderId ,orderDate ,orderStatus ,paidSate ,paidMethod ,deliveryAddress ,orderName ,orderPhone ,totalPrice ) values(?,?,?,?,?,?,?,?,?)";
		Connection conn = ds.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement preparedStatement = conn.prepareStatement(addsql);
		java.sql.Timestamp orderDate = stringToSqlDate();
		
		preparedStatement.setString(1, bean.getorderId());
		preparedStatement.setTimestamp(2, orderDate);
		preparedStatement.setString(3, bean.getorderStatus());
		preparedStatement.setString(4, bean.getpaidSate());
		preparedStatement.setString(5, bean.getpaidMethod());
		preparedStatement.setString(6, bean.getdeliveryAddress());
		preparedStatement.setString(7, bean.getorderName());
		preparedStatement.setString(8, bean.getorderPhone());
		preparedStatement.setString(9, bean.gettotalPrice());
		
		preparedStatement.executeUpdate();
		String delsql = "DELETE FROM cart WHERE memberId   =?";

		PreparedStatement preparedStatement1 = conn.prepareStatement(delsql);
		preparedStatement1.setString(1, bean.getmemberId());
		preparedStatement1.executeUpdate();
		conn.setAutoCommit(true);
		
		preparedStatement1.close();
		preparedStatement.close();
		conn.close();
	}
	
	
	public List<OrderBean> findAllOrder() throws Exception {

		List<OrderBean> AllOrder = new ArrayList<OrderBean>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * from orders");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				OrderBean order = new OrderBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10));
				AllOrder.add(order);
			}
		}
//		System.err.println(AllOrder);
		return AllOrder;
	}
	
	public void updateOrderSatusByOrderId(String Satus, String orderId ) throws SQLException, ParseException {

		String sql = "UPDATE orders SET orderStatus =? , newDate=? WHERE orderId=?;";
		Connection conn = ds.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		java.sql.Timestamp orderDate = stringToSqlDate();

		preparedStatement.setString(1, Satus);
		preparedStatement.setTimestamp(2, orderDate);
		preparedStatement.setString(3, orderId);
//		System.out.println("OK");

		preparedStatement.executeUpdate();
		preparedStatement.close();
		conn.close();
	}
	

}
