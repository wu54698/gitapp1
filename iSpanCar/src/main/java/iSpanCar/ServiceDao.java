package iSpanCar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

public class ServiceDao {

	DataSource ds = null;
	
		
	public ServiceDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/iSpan_car_Databace");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}
	

//增加
	public void addCarbean(ServiceBean Sevice) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "insert into Service values(?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, Sevice.getService_name());
		preState.setBinaryStream(2, Sevice.getCarimage().getBinaryStream());
		preState.setString(3, Sevice.getServicedescription());
		preState.setString(4, Sevice.getServiceinfomation());
		preState.setString(5, Sevice.getContactperson());
		preState.setString(6, Sevice.getReseller_nonreseller());
		int row = preState.executeUpdate();
		System.out.println("新增了 " + row + "筆");
		preState.close();
	}

//刪除
	public void deleteService(String getService_name) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "delete from Service where service_name = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, getService_name);
		int row = preState.executeUpdate();
		System.out.println("刪除了 " + row + "筆");
		preState.close();
	}

//修改
	public void updateService(String service_name , String Servicedescription) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "update Service set servicedescription = ? where service_name = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, service_name);
		preState.setString(1, Servicedescription);
		
		preState.executeUpdate();
		
		System.out.println("修改完成!!");
		
		preState.close();
	}
		
//查詢
	public ServiceBean findById(String Service_name) throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "select * from Service where service_name = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, Service_name);

		ResultSet rs = preState.executeQuery();
		rs.next();

		ServiceBean Service = new ServiceBean();

		Service.setServicedescription(rs.getString("Servicedescription"));
		Service.setContactperson(rs.getString("Contactperson"));
		Service.setServiceinfomation(rs.getString("Serviceinfomation"));
		Service.setCarimage(rs.getBlob("Carimage"));
		Service.setService_name(rs.getString("Service_name"));
		Service.setReseller_nonreseller(rs.getString("Reseller_nonreseller"));

		
		rs.close();
		preState.close();

		return Service;
	}
}