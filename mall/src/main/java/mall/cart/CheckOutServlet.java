package mall.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mall.history.History;
import mall.history.HistoryDao;
import mall.history.JdbcHistoryDao;
import mall.trade.JdbcTradeDao;
import mall.trade.Trade;
import mall.trade.TradeDao;
import mall.younghun.Buyer;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet{
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
		
		String action = request.getParameter("action");

		ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

		Buyer buyer = (Buyer) request.getSession().getAttribute("buyer");
		
		if (buyer == null) {
	        response.sendRedirect(request.getContextPath() + "/loginForm");
	        return; 
	    }
		
		if(cart_list != null) {
			
			History history = new History();
			history.setBuyer(buyer);
			HistoryDao historyDao = new JdbcHistoryDao();
			historyDao.insert(history);
			int history_number = historyDao.findLatestHistory();
			history.setHistory_number(history_number);
			System.out.println(history);
			TradeDao tradeDao = new JdbcTradeDao();
			for(Cart c:cart_list) {
				Trade trade = new Trade();
				trade.setHistory(history);
				
				trade.setProduct_count(c.getQuantity());
				trade.setProduct(c);
				System.out.println(trade);
				tradeDao.insert(trade);
			}
			cart_list.clear();
			response.sendRedirect(request.getContextPath()+"/buyerhistory");
			
		}else {
				response.sendRedirect(request.getContextPath()+"/cart");
		}
		

	}		
		
}
