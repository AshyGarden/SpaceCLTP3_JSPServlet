package mall.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jy.servlet.JdbcSellerDao;
import jy.servlet.SellerDao;
import mall.younghun.Buyer;
import mall.younghun.BuyerDao;
import mall.younghun.JdbcBuyerDao;

@SuppressWarnings("serial") 
@WebServlet("/login, /loginForm") 
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	
		
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String uri = request.getRequestURI();
	    int lastIndex = uri.lastIndexOf("/");
	    String action = uri.substring(lastIndex + 1);
	    
	    BuyerDao buyerDao = new JdbcBuyerDao();
	    SellerDao sellerDao = new JdbcSellerDao();
	    
	    if(action.equals("login")) {
	        String _id = request.getParameter("id");
	        String _password = request.getParameter("password");
	        String userType = request.getParameter("userType");
	        
	        HttpSession session = request.getSession();
	        if(userType.equals("buyer")) {
	            Buyer buyer = buyerDao.findById(_id);
	            
	            if(buyer != null && buyer.getPassword().equals(_password)) {
	                session.setAttribute("buyer", buyer);
	            }
	        } else if(userType.equals("seller")) {
	            Seller seller;
	        }
	    }
	}

	
	
}
