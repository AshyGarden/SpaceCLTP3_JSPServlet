package mall.trade;

import java.util.List;

import jy.servlet.Product;
import mall.history.History;

public interface TradeDao {
	void insert(Trade trade);
	void delete(History history);
	List<Trade> findByHistoryNumber(int history_number);
	List<Trade> findByProductNumber(Product product); 
	
}
