package jy.servlet;

import java.util.ArrayList;
import java.util.List;

import mall.cart.Cart;

public interface ProductDao {
	
	void insert(Product product);
	List<Product> findAll(); 
	Product findById(int productNumber);
	Product findByName(String name);
	Product findBySellerNo(Seller seller);
	void update(Product product);
	void deleteById(int productNumber);
	List<Cart> findCartProducts(ArrayList<Cart> cartList);
	int getTotalCartPrice(ArrayList<Cart> cartList);

}
