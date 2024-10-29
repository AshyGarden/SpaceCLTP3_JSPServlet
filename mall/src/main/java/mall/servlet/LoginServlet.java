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
import jy.servlet.Seller;
import jy.servlet.SellerDao;
import mall.younghun.Buyer;
import mall.younghun.BuyerDao;
import mall.younghun.JdbcBuyerDao;

@SuppressWarnings("serial") 
@WebServlet({"/login", "/loginForm","/logout"}) 
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
	    
	    if(action.equals("loginForm")) {
	    	
	    }else if(action.equals("login")) {
	        String _id = request.getParameter("id");
	        String _password = request.getParameter("password");
	        String userType = request.getParameter("userType");
	        
	        String resultMessage = null;
	        HttpSession session = request.getSession();
	        if(userType.equals("buyer")) {
	            Buyer buyer = buyerDao.findById(_id);
	            System.out.println(buyer);
	            if(buyer != null && buyer.getPassword().equals(_password)) {
	                session.setAttribute("buyer", buyer);
	            }
	        } else if(userType.equals("seller")) {
	            Seller seller = sellerDao.findById(_id);
	            if(seller != null && seller.getPassword().equals(_password)) {
	            	session.setAttribute("seller", seller);
	            }
	        }else {
	        	resultMessage = "Id or password is wrong.";
	        	
	        }
	        request.setAttribute("resultMessage", resultMessage);
	    }else if(action.equals("logout")) {
	    	HttpSession session = request.getSession();
	    	if(session.getAttribute("buyer")!=null) {
	    		session.removeAttribute("buyer");
	    	}else if(session.getAttribute("seller")!=null) {
	    		session.removeAttribute("seller");
	    	}
	    }
	    
	    String dispatcherUrl = null;
	    
	    if(action.equals("loginForm")) {
	    	dispatcherUrl = "/pages/authentication/login.jsp";
	    	
	    }else if(action.equals("login")) {
	    	HttpSession session = request.getSession();
	    	if((session.getAttribute("buyer")!=null)||(session.getAttribute("seller")!=null)) {
	    		dispatcherUrl = "/index";
	    	}else{
	    		dispatcherUrl = "/loginForm";
	    	}
	    }else if(action.equals("logout")) {
	    	dispatcherUrl = "/index";
	    }
	    
	    if(dispatcherUrl != null) {
	    	RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
	    	rd.forward(request, response);
	    }
	    
	}

	
	
}
