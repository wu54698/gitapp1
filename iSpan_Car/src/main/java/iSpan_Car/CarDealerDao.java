package iSpan_Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class CarDealerDao {
	
	DataSource ds = null;

	public CarDealerDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/iSpan_Car_DataBase");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public java.sql.Time StringToTime(String time) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date udate = dateFormat.parse(time);  //型態HH:mm:ss的字串轉util.date
		Time sTime = new java.sql.Time(udate.getTime()); //轉sql.time
		return sTime;
	}
	
	//新增車商
	public void addCarDealer(CarDealerBean bean) throws SQLException, ParseException {
		String sql = "insert into carDealerInfo values(?, ?, ?, ?, ?, ?)";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, bean.getCarDealName());
		preState.setInt(2, bean.getCarDealPhone());
		preState.setString(3, bean.getCarDealAddress());
		Time openTime = StringToTime(bean.getOpenTime());
		preState.setTime(4, openTime);
		preState.setString(5, bean.getContactPerson());
		preState.setInt(6, bean.getCarDealVATNumber());
		preState.execute();
		preState.close();
		conn.close();
	}
	
	//透過車商名稱刪除車商
	public void deleteCarDealer(String carDealName) throws SQLException {
		String sql = "delete from carDealerInfo where carDealerName = ?";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, carDealName);
		preState.execute();
		System.out.println("刪除ok!");
		preState.close();
		conn.close();
	}

	
	//透過統編來搜尋車商
	public List<CarDealerBean> findByVATNumberLike(int carDealVATNumber) throws SQLException{
		String sql = "select * from carDealerInfo where carDealerVATNumber like ?";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, "%" + carDealVATNumber + "%");
		ResultSet rs = preState.executeQuery();
		
		List<CarDealerBean> list = new LinkedList<>();
		
		while(rs.next()) {
			CarDealerBean dealerBean = new CarDealerBean();
			dealerBean.setCarDealName(rs.getString("carDealerName"));
			dealerBean.setCarDealPhone(rs.getInt("carDealerPhone"));
			dealerBean.setCarDealAddress(rs.getString("carDealerAddress"));
			dealerBean.setOpenTime(rs.getString("openTime"));
			dealerBean.setContactPerson(rs.getString("contactPerson"));
			dealerBean.setCarDealVATNumber(rs.getInt("carDealerVATNumber"));
			list.add(dealerBean);
		}
			rs.close();
			preState.close();
			conn.close();
			return list;

	}

	

}