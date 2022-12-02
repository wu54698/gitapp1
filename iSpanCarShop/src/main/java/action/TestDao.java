package action;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.ShopDetailBean;
import model.ShopDetailDao;


public class TestDao {

	public static void main(String[] args) {
		
			
		ShopDetailDao sDao = new ShopDetailDao();	
		
		ShopDetailBean sdb1 = new ShopDetailBean("aaa","ttt","sss",200,20,"2022-12-01","this is info");
		try {
			sDao.addProduct(sdb1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
