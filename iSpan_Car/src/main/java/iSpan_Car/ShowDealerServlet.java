package iSpan_Car;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowDealerServlet.do")
public class ShowDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String carDealVATNumber = request.getParameter("carDealVATNumber");
			int VATNumber = Integer.parseInt(carDealVATNumber);
			CarDealerDao cDao = new CarDealerDao();

			List<CarDealerBean> list = cDao.findByVATNumberLike(VATNumber);
			
			request.setAttribute("selectVATNumber", list);
			RequestDispatcher rd = request.getRequestDispatcher("/iSpan_Car/SelectDealer.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}