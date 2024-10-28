package mall.trade;

import java.util.List;

import jy.servlet.Product;
import mall.history.History;

public interface TradeDao {
	void insert(Trade trade);
	void delete(History history);
	List<Trade> findByHistoryNumber(History history);
	List<Trade> findByProductNumber(Product product); 
	
}
