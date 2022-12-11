package dforum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=iSpan_car;encrypt=false";	
	private static String user = "sa";
	private static String pwd = "123456";
	
	private static Connection conn=null;
	
	public static Connection getConnectionForum() {
		try {
			free();
			conn= DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static boolean free() {
		if(conn==null) return false;
		try {
			if(conn.isClosed())return true;
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	

}
