package mall.trade;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mall.younghun.Buyer;

@WebServlet({"/buyertrade","/sellertrade"})
public class TradeServlet extends HttpServlet {
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
		
		if(action.equals("buyertrade")) {
			HttpSession session = request.getSession();
			Buyer buyer =(Buyer) session.getAttribute("buyer");
			TradeDao tradeDao = new JdbcTradeDao();
			List<Trade> trade = tradeDao.findByHistoryNumber(Integer.parseInt(request.getParameter("history_number")));
			request.setAttribute("trade", trade);
			
			
		}else if(action.equals("sellertrade")) {
			
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("buyertrade")) {
			dispatcherUrl = "/pages/trade/buyertrade.jsp";
			
		}else if(action.equals("sellertrade")) {
			
		}
	    if(dispatcherUrl != null) {
	    	RequestDispatcher rd = request.getRequestDispatcher(dispatcherUrl);
	    	rd.forward(request, response);
	    }
		
		
	}
}
