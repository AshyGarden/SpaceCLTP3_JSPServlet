package jy.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mall.global.DataSource;

public class JdbcProductDao implements ProductDao{

	@Override
	public void insert(Product product) {
		try(Connection connection = DataSource.getDataSource();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PRODUCT (PRICE, NAME, DESCRIPTION, SELLER_ID) \r\n"
	            		+ "VALUES (?, ?, ?, ?)"))
	        {

	            preparedStatement.setInt(1, product.getPrice());
	            preparedStatement.setString(2, product.getName());
	            preparedStatement.setString(3, product.getDescription());
	            preparedStatement.setString(4, product.getSeller().getSellerId());

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
                
                
                product.setProductNumber(rs.getInt("PRODUCT_NUMBER"));
                product.setPrice(rs.getInt("PRICE"));
                product.setName(rs.getString("NAME"));
                product.setDescription(rs.getString("DESCRIPTION"));
                
                Seller seller = new Seller();
                seller.setSellerId(rs.getString("SELLER_NUMBER"));
                product.setSeller(seller);
               
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
	}
	

	@Override
	public Product findById(int productNumber) {
		Product product = null;

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCT_NUMBER = ?")) {
        	
            pStat.setInt(1, productNumber);
            ResultSet rs = pStat.executeQuery();

            if(rs.next()) {
            	product = new Product();
            	
            	product.setProductNumber(rs.getInt("product_number"));
            	product.setName(rs.getString("name"));
            	product.setPrice(rs.getInt("price"));
            	product.setCategory(rs.getString("category"));
            	product.setDescription(rs.getString("description"));
            	product.setDiscountPercentage(rs.getInt("discount_percentage"));
            	
            	Seller seller = new Seller();
            	seller.setSellerId(rs.getString("seller_id"));
            	product.setSeller(seller);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
	}

	@Override
	public Product findByName(String name) {
		Product product = null;

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM PRODUCT WHERE Lower(Name) LIKE '%?%'")) {
        	
            pStat.setString(1, name);
            ResultSet rs = pStat.executeQuery();

            if(rs.next()) {
            	product = new Product();
            	
            	product.setProductNumber(rs.getInt("product_number"));
            	product.setName(rs.getString("name"));
            	product.setPrice(rs.getInt("price"));
            	product.setCategory(rs.getString("category"));
            	product.setDescription(rs.getString("description"));
            	product.setDiscountPercentage(rs.getInt("discount_percentage"));
            	
            	Seller seller = new Seller();
            	seller.setSellerId(rs.getString("seller_id"));
            	product.setSeller(seller);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
	}

	@Override
	public void update(Product product) {
		try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE PRODUCT SET PRICE = ?, NAME = ?,"
    					+ "DESCRIPTION = ?,SELLER_ID = ? WHERE PRODUCT_NUMBER = ?")){ 
    			
    		
    			pStatement.setInt(1, product.getPrice());
    			pStatement.setString(2, product.getName());    		
    			pStatement.setString(3, product.getDescription());
    			pStatement.setString(4, product.getSeller().getSellerId());
    			pStatement.setInt(5, product.getProductNumber());

    			pStatement.executeUpdate();
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int productNumber) {
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement preparedStatement
				= connection.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_NUMBER = 1")) {
			preparedStatement.setInt(1, productNumber);
			preparedStatement.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Product findBySellerNo(Seller seller) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
