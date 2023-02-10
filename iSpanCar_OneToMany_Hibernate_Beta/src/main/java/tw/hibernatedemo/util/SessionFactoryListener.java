package tw.hibernatedemo.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SessionFactoryListener implements ServletContextListener {
	
    public SessionFactoryListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	HibernateUtil.closeSessionFactory();
    	System.out.println("SessionFactory Closed!!");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	HibernateUtil.getSessionFactory();
    	System.out.println("Create SessionFactory!!");
    }
	
}
