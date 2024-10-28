package jy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet("/signinSeller") 
public class SellerSigninServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/"); 
		String action = uri.substring(lastIndex+1); 
		String dispatcherUrl = null;
		
		if(action.equals("signinSeller")) {
			
			JdbcSellerDao jdbcSellerDao = new JdbcSellerDao();
			Seller seller = new Seller();
			
			seller.setName(request.getParameter("name"));
			seller.setSeller_id(request.getParameter("seller_id"));
			seller.setPassword(request.getParameter("password"));
			seller.setPostal_code(request.getParameter("postal_code"));
			seller.setStreet_address(request.getParameter("street_address"));
			seller.setAddress_detail(request.getParameter("address_detail"));
			seller.setPhone_number(request.getParameter("phone_number"));
			seller.setEmail(request.getParameter("email"));
			seller.setCompany_name(request.getParameter("company_name"));
			
			jdbcSellerDao.insert(seller);
			
			dispatcherUrl ="/pages/authentication/login.jsp";

		}else {
		
		//System.out.println(action);

			dispatcherUrl ="/pages/authentication/signinSeller.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
		
	}

}
