package jy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet({"/updateForm", "/deleteSeller"}) 
public class DeleteSeller extends HttpServlet{
	
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
	
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		if(action.equals("delteSeller")) {
			
			
			JdbcSellerDao jdbcSellerDao = new JdbcSellerDao();
			Seller seller = new Seller();
			
			seller.setSellerId(request.getParameter("seller_id"));
			
			System.out.println(seller.toString());
			
			
			jdbcSellerDao.update(seller);
			
			dispatcherUrl ="/updateForm";
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		}else if(action.equals("updateForm")) {
			dispatcherUrl ="/index.jsp";
		}else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		if (dispatcherUrl != null) {
	        RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
	        rd.forward(request, response);
	    } else {
	        response.sendError(HttpServletResponse.SC_NOT_FOUND);
	    }
	}

}
