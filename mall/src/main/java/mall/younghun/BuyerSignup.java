package mall.younghun;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jy.servlet.JdbcSellerDao;
import jy.servlet.Seller;

@WebServlet("/buyersignup")
public class BuyerSignup extends HttpServlet{
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
		
	
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		if(action.equals("buyersignup")) {
			
			
			BuyerDao buyerDao = new JdbcBuyerDao();
			Buyer buyer = new Buyer();
			
			buyer.setName(request.getParameter("name"));
			buyer.setBuyer_id(request.getParameter("buyer_id"));
			buyer.setPassword(request.getParameter("password"));
			buyer.setPostal_code(request.getParameter("postnum"));
			buyer.setStreet_address(request.getParameter("addr1"));
			buyer.setAddress_detail(request.getParameter("addr2"));
			buyer.setPhone_number(request.getParameter("phone_number"));
			buyer.setEmail(request.getParameter("email"));
			
			buyerDao.insert(buyer);
			
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		}
		
		String dispatcherUrl = null;
		
		
		if(action.equals("buyersignup")) {
			dispatcherUrl = "/index";
		}
	    if(dispatcherUrl != null) {
	    	RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
	    	rd.forward(request, response);
	    }
		
	}

}
