package mall.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	process(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	process(req, resp);
    	
    }
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		
		response.setContentType("text/html;charset=UTF-8");

			try(PrintWriter out = response.getWriter()){
				ArrayList<Cart> cartList = new ArrayList<>();
				
				
				int id = Integer.parseInt(request.getParameter("productNumber"));
				Cart cart = new Cart();
				cart.setProductNumber(id);
				cart.setQuantity(1);
				
				HttpSession session = request.getSession();
				ArrayList<Cart> session_cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
				if(session_cart_list == null) {
					cartList.add(cart);
					session.setAttribute("cart-list", cartList);
//					out.println("session created and added");
					response.sendRedirect("index");
					return;
					
				}else {
					cartList = session_cart_list;
					boolean cartStatus = false;
					
					
					for(Cart c:cartList) {
//						out.println(c.getProductNumber());
						if(c.getProductNumber()==id) {
							cartStatus = true;
//							out.println("product exist");
							response.sendRedirect(request.getContextPath()+"/cart");
						}
						
					}
					if(!cartStatus) {
						cartList.add(cart);
//						out.println("product added");
						response.sendRedirect("index");
						
					}
				}
			}

	}
    
}