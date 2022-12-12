package ispan_cart;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig()
@WebServlet("/CartDeleteServlet.do")
public class CartDeleteServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
  try {
   request.setCharacterEncoding("UTF-8");
   String cartId = request.getParameter("cartId");
   CartDao cdao = new CartDao();
   cdao.deletecartId(cartId);
   String contextPath = request.getContextPath();
   response.sendRedirect(contextPath + "/QueryAllCart.do");
  } catch (SQLException e) {
   e.printStackTrace();
  } catch (ParseException e) {
   e.printStackTrace();
  } catch (UnsupportedEncodingException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}