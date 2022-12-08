package carInfo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import carInfo.model.CarInfoBean;

//import iSpan_Car.model.CarInfoBean;


public class CarInfoDao {
	DataSource ds = null;

	public CarInfoDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/iSpan_Car_DataBase"); //連線至context.xml > java:comp/env/name
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Blob filetoBlob(InputStream is, long size) 
							throws IOException, SerialException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
		
	}
	
	
	//新增車輛商品
	public void addCarInfo(CarInfoBean bean) throws SQLException {
		String sql = "insert into carInfo values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, bean.getCarNo());
		preState.setString(2, bean.getCarDealName());
		preState.setString(3, bean.getAccountNumber());
		preState.setString(4, bean.getCarBrand());
		preState.setString(5, bean.getCarName());
		preState.setInt(6, bean.getStock());
		preState.setBinaryStream(7, bean.getCarImage().getBinaryStream());
		preState.setString(8, bean.getCarDescription());
		preState.setString(9, bean.getAnnounceDate());
		preState.execute();
		preState.close();
		conn.close();
		
	}
	
	//透過車輛編號刪除車輛
	public void deleteCarInfo(int carNo) throws SQLException {
		String sql = "delete from carInfo where carNo = ?";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, carNo);
		preState.execute();
		preState.close();
		conn.close();
	}
	
	
	//透過車商名稱修改車輛資訊
	public void updateByCarNo(CarInfoBean bean) throws SQLException {
		String sql = "update carInfo set carDealName = ?, "
				+ "accountNumber = ?, carBrand = ?, carName = ?, stock = ?, "
				+ "carImage = ?, carDescription = ?, announceDate = ? where carNo = ?";
		
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, bean.getCarDealName());
		preState.setString(2, bean.getAccountNumber());
		preState.setString(3, bean.getCarBrand());
		preState.setString(4, bean.getCarName());
		preState.setInt(5, bean.getStock());
		preState.setBinaryStream(6, bean.getCarImage().getBinaryStream());
		preState.setString(7, bean.getCarDescription());
		preState.setString(8, bean.getAnnounceDate());
		preState.setInt(9, bean.getCarNo());
		preState.execute();
		preState.close();
		conn.close();
		
	}
	
	//透過品牌找車輛
	public List<CarInfoBean> findByCarBrandLike(String carBrand) throws SQLException{
		String sql = "select * from carInfo where carBrand = ?";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, carBrand);
		ResultSet rs = preState.executeQuery();
		
		List<CarInfoBean> list = new LinkedList<>();
		
		while(rs.next()) {
			CarInfoBean infoBean = new CarInfoBean();
			infoBean.setCarNo(rs.getInt("CarNo"));
			infoBean.setCarDealName(rs.getString("carDealName"));
			infoBean.setAccountNumber(rs.getString("accountNumber"));
			infoBean.setCarBrand(rs.getString("carBrand"));
			infoBean.setCarName(rs.getString("carName"));
			infoBean.setStock(rs.getInt("stock"));
			infoBean.setCarImage(rs.getBlob("carImage"));
			infoBean.setCarDescription(rs.getString("carDescription"));
			infoBean.setAnnounceDate(rs.getString("announceDate"));
			list.add(infoBean);
		}
			rs.close();
			preState.close();
			conn.close();
			return list;
	
	}
	
	//透過carNo找車輛(圖片用)
	public List<CarInfoBean> findByCarNoLike(int carNo) throws SQLException{
		String sql = "select * from carInfo where carNo = ?";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, carNo);
		ResultSet rs = preState.executeQuery();
		
		List<CarInfoBean> list = new LinkedList<>();
		while(rs.next()) {
			CarInfoBean infoBean = new CarInfoBean();
			infoBean.setCarNo(rs.getInt("CarNo"));
			infoBean.setCarDealName(rs.getString("carDealName"));
			infoBean.setAccountNumber(rs.getString("accountNumber"));
			infoBean.setCarBrand(rs.getString("carBrand"));
			infoBean.setCarName(rs.getString("carName"));
			infoBean.setStock(rs.getInt("stock"));
			infoBean.setCarImage(rs.getBlob("carImage"));
			infoBean.setCarDescription(rs.getString("carDescription"));
			infoBean.setAnnounceDate(rs.getString("announceDate"));
			list.add(infoBean);
		}
			rs.close();
			preState.close();
			conn.close();
			return list;
	}
	
	
	
	//搜尋全車輛
	public List<CarInfoBean> findAllCar() throws SQLException{
		String sql = "select * from carInfo";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet rs = preState.executeQuery();
		
		List<CarInfoBean> list = new LinkedList<>();
		
		while(rs.next()) {
			CarInfoBean infoBean = new CarInfoBean();
			infoBean.setCarNo(rs.getInt("carNo"));
			infoBean.setCarDealName(rs.getString("carDealName"));
			infoBean.setAccountNumber(rs.getString("accountNumber"));
			infoBean.setCarBrand(rs.getString("carBrand"));
			infoBean.setCarName(rs.getString("carName"));
			infoBean.setStock(rs.getInt("stock"));
			infoBean.setCarImage(rs.getBlob("carImage"));
			infoBean.setCarDescription(rs.getString("carDescription"));
			infoBean.setAnnounceDate(rs.getString("announceDate"));
			list.add(infoBean);
		}
			rs.close();
			preState.close();
			conn.close();
			return list;
	}
	
}