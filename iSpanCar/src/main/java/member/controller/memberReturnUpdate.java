package member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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

@WebServlet("/memberReturnUpdate.do")
public class memberReturnUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String accountnumber = request.getParameter("accountnumber");
		String memberpassword = request.getParameter("memberpassword");
		String memberName = request.getParameter("memberName");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String memberaddress = request.getParameter("memberaddress");
		String platenumber = request.getParameter("platenumber");
		String birthday = request.getParameter("birthday");
		String idnumber = request.getParameter("idnumber");
		String cardnumber = request.getParameter("cardnumber");
		
		MemberBean mb = new MemberBean(accountnumber, memberpassword, memberName, phonenumber, email, memberaddress, platenumber, birthday, idnumber,cardnumber);
		
		MemberDao mDao = new MemberDao();
		mDao.updateByAccountnumber(mb);
		
		MemberBean newMemberBean = mDao.findbyaccountnumberwithoutimage(accountnumber);
		System.out.println(newMemberBean.toString());
		List<MemberBean> list = new ArrayList();
		list.add(newMemberBean);
		GsonBuilder builder = new GsonBuilder();
		builder.serializeNulls();
	    Gson gson = builder.create();
	    String JsonString = gson.toJson(list);//Gson物件.toJson方法將List轉成json格式的String
		
		response.getWriter().write(JsonString);
		response.getWriter().flush();
		response.getWriter().close();
	
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	
	}

}
