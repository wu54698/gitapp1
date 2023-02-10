package member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import member.dao.MemberDao;
import member.model.MemberBean;

@WebServlet("/memberReturnUpdateCancel.do")
public class memberReturnUpdateCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			String accountnumber = request.getParameter("accountnumber");
			MemberDao mDao = new MemberDao();
			
			List<MemberBean> list = mDao.findbyaccountnumberwithoutimage(accountnumber);
		
			GsonBuilder builder = new GsonBuilder();
		    builder.serializeNulls();
		    Gson gson = builder.create();
			String JsonString = gson.toJson(list);//Gson物件.toJson方法將List轉成json格式的String
//			System.out.println(JsonString);
			response.getWriter().write(JsonString);
			response.getWriter().flush();
			response.getWriter().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
