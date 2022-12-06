package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
			String urlStr = "jdbc:sqlserver://localhost:1433;databaseName=projecttwo;TrustServerCertificate=true";
			Connection conn= DriverManager.getConnection(urlStr, "sa", "123");
			
			boolean status = !conn.isClosed();
			System.out.println("status: "+status);
			conn.close();
			
			System.out.println("OK");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("沒找到");
			e.printStackTrace();
		}

	}

}
