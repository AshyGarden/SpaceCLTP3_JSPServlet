package mall.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class ShowCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		if(action.equals("cart")) {
			
		}
		String dispatcherUrl = null;
		
		if(action.equals("cart")) {
			dispatcherUrl = "/pages/cart/cart.jsp";
			
		}
		if(dispatcherUrl != null) {
	    	RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
	    	rd.forward(request, response);
	    }
	
	}
}
