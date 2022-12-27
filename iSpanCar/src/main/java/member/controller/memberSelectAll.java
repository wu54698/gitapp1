package member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.model.MemberBean;
import member.service.MemberService;


@WebServlet("/memberSelectAll.do")
public class memberSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		MemberService mService = new MemberService();
		
		List<MemberBean> list;
			list = mService.selectAll();
			
		request.setAttribute("selectAll", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberSelectAll.jsp");
		rd.forward(request, response);
		return;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
