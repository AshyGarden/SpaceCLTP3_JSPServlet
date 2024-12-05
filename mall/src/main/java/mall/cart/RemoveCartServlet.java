package mall.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removeitem")
public class RemoveCartServlet extends HttpServlet{
	
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
		String id = request.getParameter("productNumber");
		if(id!= null) {
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			if(cart_list != null) {
				for(Cart c:cart_list) {
					if(c.getProductNumber() == Integer.parseInt(id)) {
						cart_list.remove(cart_list.indexOf(c));
						System.out.println(cart_list);
						break;
					}
				}
				response.sendRedirect(request.getContextPath()+"/cart");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/cart");
		}
	
	}


}
