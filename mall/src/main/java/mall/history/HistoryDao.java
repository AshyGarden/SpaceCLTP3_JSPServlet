package mall.history;

import java.util.List;

public interface HistoryDao {
	void insert(History history);
	void deleteByHistoryNumber(int history_number);
	void deleteByBuyerNumber(int buyer_number);
	List<History> findByBuyerNumber(int buyer_number);
	
	
}
