package mall.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/quantitychange")
public class QuantityChangeServlet extends HttpServlet{
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
		try (PrintWriter out = response.getWriter()) {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("productNumber"));
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

			if (action != null && id >= 1) {
				if (action.equals("inc")) {
					for (Cart c : cart_list) {
						if (c.getProductNumber() == id) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							response.sendRedirect(request.getContextPath()+"/cart");
						}
					}
				}

				if (action.equals("dec")) {
					for (Cart c : cart_list) {
						if (c.getProductNumber() == id && c.getQuantity() > 1) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							break;
						}
					}
					response.sendRedirect(request.getContextPath()+"/cart");
				}
			} else {
				response.sendRedirect(request.getContextPath()+"/cart");
			}
		}
	}
		
	
}

