package mall.younghun;

public interface HistoryDao {
	void insert(Buyer buyer);
	void delete(int history_number);
}
