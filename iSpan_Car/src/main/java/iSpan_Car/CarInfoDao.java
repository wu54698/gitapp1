package iSpan_Car;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;


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
		preState.setInt(1, bean.getCarDealVATNumber());
		preState.setString(2, bean.getCarDealName());
		preState.setInt(3, bean.getAccountNumber());
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
	
	//透過庫存刪除車輛
	public void deleteCarInfo(int stock) throws SQLException {
		String sql = "delete from carInfo where stock = ?";
		Connection conn = ds.getConnection();
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, stock);
		preState.execute();
		preState.close();
		conn.close();
	}
	
	//透過品牌找車輛
	
	
	
	
}
