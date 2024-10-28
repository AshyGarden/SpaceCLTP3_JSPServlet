package mall.trade;

import jy.servlet.Product;
import mall.history.History;

public interface TradeDao {
	void insert(Trade trade);
	void delete(History history);
	Trade findByHistoryNumber(History history);
	Trade findByProductNumber(Product product); 
	
}
