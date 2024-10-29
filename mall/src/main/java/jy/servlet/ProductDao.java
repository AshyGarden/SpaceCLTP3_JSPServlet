package jy.servlet;

import java.util.List;

public interface ProductDao {
	
	void insert(Product product);
	List<Product> findAll(); 
	Product findById(int productNumber);
	Product findByName(String name);
	Product findBySellerNo(Seller seller);
	void update(Product product);
	void deleteById(int productNumber);

}
