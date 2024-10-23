package Àç¿¬.servlet;

import java.util.List;   

public interface SellerDao {
	
	void insert(Seller seller);
	List<Seller> findAll(); 
	Seller findById(int seller_number);
	void update(Seller seller);
	void deleteById(int seller_number);

}
