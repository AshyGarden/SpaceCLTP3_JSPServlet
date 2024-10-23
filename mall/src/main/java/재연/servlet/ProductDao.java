package Àç¿¬.servlet;

import java.util.List;

public interface ProductDao {
	
	void insert(Product product);
	List<Product> findAll(); 
	Product findById(int product_number);
	Product findByName(String name);
	Product findBySellerNo(Seller seller);
	void update(Product product);
	void deleteById(int product_number);

}
