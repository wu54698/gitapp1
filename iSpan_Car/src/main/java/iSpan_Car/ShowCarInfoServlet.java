package iSpan_Car;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowCarInfoServlet.do")
public class ShowCarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String stock = request.getParameter("stock");
		int amount = Integer.parseInt(stock);
		CarInfoDao infoDao = new CarInfoDao();
		
		
		
		
	}

}
