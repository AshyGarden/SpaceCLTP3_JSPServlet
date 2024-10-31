package jy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet({"/updateForm", "/updateSeller"}) 
public class UpdateSeller extends HttpServlet{
	
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
	
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		if(action.equals("updateSeller")) {
			
			
			JdbcSellerDao jdbcSellerDao = new JdbcSellerDao();
			Seller seller = new Seller();
			
			seller.setName(request.getParameter("name"));
			seller.setSellerId(request.getParameter("seller_id"));
			seller.setPassword(request.getParameter("password"));
			seller.setPostalCode(request.getParameter("postnum"));
			seller.setStreetAddress(request.getParameter("addr1"));
			seller.setAddressDetail(request.getParameter("addr2"));
			seller.setPhoneNumber(request.getParameter("phone_number"));
			seller.setEmail(request.getParameter("email"));
			seller.setCompanyName(request.getParameter("company_name"));
			
			System.out.println(seller.toString());
			
			
			jdbcSellerDao.update(seller);
			
			//dispatcherUrl ="/pages/authentication/login.jsp";
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		}else if(action.equals("updateForm")) {
			dispatcherUrl ="/pages/authentication/updateForm.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
		
	}

}
