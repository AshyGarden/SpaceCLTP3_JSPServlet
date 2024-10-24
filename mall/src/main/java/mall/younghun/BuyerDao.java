package mall.younghun;

import java.util.List;

public interface BuyerDao {
	void insert(Buyer buyer);
	void delete(int id);
	void update(Buyer buyer);
	Buyer findById(int id);
	List<Buyer> findAll();
	
	
	
}
