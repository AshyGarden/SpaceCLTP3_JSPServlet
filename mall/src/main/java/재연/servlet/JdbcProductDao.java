package Àç¿¬.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao{

	@Override
	public void insert(Product product) {
		try(Connection connection = DataSource.getDataSource();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT (PRICE, NAME, DESCRIPTION, SELLER_ID) \r\n"
	            		+ "VALUES (?, ?, ?, ?)"))
	        {

	            preparedStatement.setInt(1, product.price);
	            preparedStatement.setString(2, product.name);
	            preparedStatement.setString(3, product.description);
	            preparedStatement.setString(4, product.getSeller().seller_id);

	            preparedStatement.executeUpdate();

	        }catch (SQLException e){

	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM PRODUCT ORDER BY PRODUCT_NUMBER");

             ResultSet rs = pStat.executeQuery()) {

            while(rs.next()) {
                Product product = new Product();
                
                
                product.setProduct_number(rs.getInt("PRODUCT_NUMBER"));
                product.setPrice(rs.getInt("PRICE"));
                product.setName(rs.getString("NAME"));
                product.setDescription(rs.getString("DESCRIPTION"));
                
                Seller seller = new Seller();
                seller.setSeller_id(rs.getString("SELLER_NUMBER"));
                product.setSeller(seller);
               
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
	}
	

	@Override
	public Product findById(int product_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int product_number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findBySellerNo(Seller seller) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
