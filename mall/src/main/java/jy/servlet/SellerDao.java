package jy.servlet;

import java.util.List;   

public interface SellerDao {
	
	void insert(Seller seller);
	List<Seller> findAll(); 
	Seller findById(String sellerId);
	void update(Seller seller);
	void deleteById(String sellerId);

}
