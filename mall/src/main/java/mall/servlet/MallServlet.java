package mall.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jy.servlet.JdbcProductDao;
import jy.servlet.Product;
import jy.servlet.ProductDao;

@SuppressWarnings("serial") 
@WebServlet("/index") 
public class MallServlet extends HttpServlet{
	
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
		String action = uri.substring(lastIndex+1); 
		

		String dispatcherUrl = "/index.jsp";
		if(action.equals("productinfo")) {
			String productName = request.getParameter("productname");
			ProductDao productDao = new JdbcProductDao();
			Product product = productDao.findByName(productName);
			request.setAttribute("product", product);
		}
		
		
		if(action.equals("productinfo")) {
			dispatcherUrl = "/products/productinfo.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
		
	}
	
}
