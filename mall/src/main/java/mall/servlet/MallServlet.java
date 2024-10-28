package mall.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jy.servlet.JdbcProductDao;
import jy.servlet.Product;
import jy.servlet.ProductDao;
import mall.history.History;
import mall.history.HistoryDao;
import mall.history.JdbcHistoryDao;
import mall.younghun.Buyer;
import mall.younghun.BuyerDao;
import mall.younghun.JdbcBuyerDao;

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
		

		if(action.equals("login")) {
			String _id = request.getParameter("id");
			String _password = request.getParameter("password");
			BuyerDao buyerDao = new JdbcBuyerDao();
			Buyer buyer = buyerDao.findById(_id);
			if(buyer != null && buyer.getPassword().equals(_password)) {
				HttpSession session = request.getSession();
				session.setAttribute("buyer", buyer);
			}
		}else if(action.equals("productinfo")) {
			String productName = request.getParameter("productname");
			ProductDao productDao = new JdbcProductDao();
			Product product = productDao.findByName(productName);
			request.setAttribute("product", product);
		}else if(action.equals("history")) {
			HttpSession session = request.getSession();
			Buyer buyer = (Buyer) session.getAttribute("buyer");
			HistoryDao historyDao = new JdbcHistoryDao();
			List<History> history = historyDao.findByBuyerNumber(buyer.getBuyer_number());
			request.setAttribute("history", history);
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("login")) {
			HttpSession session = request.getSession();
			if(session.getAttribute("buyer") != null) {
				dispatcherUrl = "/index.jsp";
			}else {
				dispatcherUrl = "/authentication/login.jsp";
			}
		}else if(action.equals("productinfo")) {
			dispatcherUrl = "/products/productinfo.jsp";
		}else if(action.equals("history")) {
			dispatcherUrl = "/history/history.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
		rd.forward(request, response);
		
	}
	
}
