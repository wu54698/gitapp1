

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//SELECT T.SN, T.time, P.SN AS PSN, P.title AS Ptitle, P.isOP AS Pisop, C.SN AS CSN, C.name AS Cname, M.SN AS MSN,M.name AS Mname FROM thread AS T 
//LEFT JOIN category AS C on C.SN=T.categorySN 
//LEFT JOIN post AS P on P.threadSN=T.SN 
//LEFT JOIN member AS M on M.SN=P.memberSN 
//FOR JSON PATH  

public class QueryHelper {
	Connection conn;

	public String getThreads() {
		conn = ConnectionUtil.getConnectionForum();
		String str ="";
		try {
			String sqlstr = "SELECT T.SN, T.time, P.SN AS PSN, P.title AS Ptitle, P.isOP AS Pisop, C.SN AS CSN, C.name AS Cname, M.SN AS MSN,M.name AS Mname FROM thread AS T ";
			sqlstr += "LEFT JOIN category AS C on C.SN=T.categorySN ";
			sqlstr += "LEFT JOIN post AS P on P.threadSN=T.SN ";
			sqlstr += "LEFT JOIN member AS M on M.SN=P.memberSN ";
			sqlstr += "WHERE P.isOP =1 ";
			sqlstr += "FOR JSON PATH  ";
			PreparedStatement pstmt = conn.prepareStatement(sqlstr);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				str += rs.getNString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.free();
		}
		return str;
	}
	
	public String getThread(int threadSN) {
		conn = ConnectionUtil.getConnectionForum();
		String str ="";
		try {
			String sqlstr = "SELECT T.SN, T.time AS Ttime, P.SN AS PSN, P.title AS Ptitle, P.body AS Pbody, P.time AS Ptime,P.isOP AS Pisop,";
			sqlstr += "C.SN AS CSN, C.name AS Cname, M.SN AS MSN,M.name AS Mname FROM thread AS T ";
			sqlstr += "LEFT JOIN category AS C on C.SN=T.categorySN ";
			sqlstr += "LEFT JOIN post AS P on P.threadSN=T.SN ";
			sqlstr += "LEFT JOIN member AS M on M.SN=P.memberSN ";
			sqlstr += "WHERE threadSN=? ";
			sqlstr += "FOR JSON PATH  ";
			PreparedStatement pstmt = conn.prepareStatement(sqlstr);
			pstmt.setInt(1, threadSN);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				str += rs.getNString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.free();
		}
		return str;
	}
	
	public String getCategories() {
		conn = ConnectionUtil.getConnectionForum();
		String str ="";
		try {
			String sqlstr = "SELECT * FROM category ";
			sqlstr += "FOR JSON PATH";

			PreparedStatement pstmt = conn.prepareStatement(sqlstr);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				str += rs.getNString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.free();
		}
		return str;
	}
	
	public int newThread(int categorySN) {
		conn = ConnectionUtil.getConnectionForum();
		int rt0SN =0;
		try {
			String sqlstr = "INSERT INTO thread (time, categorySN) "
			+ "VALUES (GETDATE(), ?); "
			+"SELECT SCOPE_IDENTITY();";
			
			PreparedStatement pstmt = conn.prepareStatement(sqlstr);
			pstmt.setInt(1, categorySN);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				rt0SN += rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.free();
		}
		return rt0SN;
	}

	public void newPost(Post post) {
		conn = ConnectionUtil.getConnectionForum();
		
		try {
			String sqlstr = "INSERT INTO post ( title  , body  , time  , isOP  , memberSN  , threadSN )     VALUES\r\n"
					+ "(?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sqlstr);
			pstmt.setNString(1,post.title);
			pstmt.setNString(2,post.body);
			pstmt.setTimestamp(3,post.time);
			pstmt.setInt(4,post.isOP ? 1 : 0);
			pstmt.setInt(5,post.memberSN);
			pstmt.setInt(6,post.threadSN);

			int updateCount = pstmt.executeUpdate();

		} catch (SQLException | IllegalArgumentException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.free();
		}

	}


}
