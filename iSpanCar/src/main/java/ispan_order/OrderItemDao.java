package ispan_order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ispan_cart.CartBean;

public class OrderItemDao {
	DataSource ds = null;

	public OrderItemDao() {// 連線物件
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/iSpan_car_DataBase");// 連到context.xml > java:comp/env/name
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

		public void insertOrderItemBean(OrderItemBean bean) throws SQLException, ParseException {

			String sql = "insert into orderItem values(?,?,?,?,?)";

			Connection conn = ds.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, bean.getorderId());
			preparedStatement.setString(2, bean.getproductNumber());
			preparedStatement.setString(3, bean.getproductName());
			preparedStatement.setString(4, bean.getquantity());
			preparedStatement.setString(5, bean.getproductPrice());
			

			preparedStatement.executeUpdate();
			preparedStatement.close();
			conn.close();
		}
		
		public List<OrderItemBean> findAllOrderItem() throws Exception {

			List<OrderItemBean> AllOrderItem = new ArrayList<OrderItemBean>();
			try (Connection conn = ds.getConnection();
					PreparedStatement stmt = conn.prepareStatement("SELECT * from orderItem");
					ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					OrderItemBean orderItem = new OrderItemBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5));
					AllOrderItem.add(orderItem);
				}
			}
//			System.err.println(AllOrder);
			return AllOrderItem;
		}
	

}
