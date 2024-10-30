package jy.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mall.global.DataSource;

public class JdbcSellerDao implements SellerDao{

	@Override   
	public void insert(Seller seller) {
		try(Connection connection = DataSource.getDataSource();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SELLER (SELLER_ID, PASSWORD, NAME, POSTAL_CODE, STREET_ADDRESS, ADDRESS_DETAIL, PHONE_NUMBER, EMAIL, COMPANY_NAME) VALUES (?,?,?,?,?,?,?,?,?)"))
	        {

	            preparedStatement.setString(1, seller.getSellerId());
	            preparedStatement.setString(2, seller.getPassword());
	            preparedStatement.setString(3, seller.getName());
	            preparedStatement.setString(4, seller.getPostalCode());
	            preparedStatement.setString(5, seller.getStreetAddress());
	            preparedStatement.setString(6, seller.getAddressDetail());
	            preparedStatement.setString(7, seller.getPhoneNumber());
	            preparedStatement.setString(8, seller.getEmail());
	            preparedStatement.setString(9, seller.getCompanyName());
	            

	            preparedStatement.executeUpdate();
	            
	            System.out.println(seller.toString());
	           

	        }catch (SQLException e){

	            e.printStackTrace();
	        }
	    }
		

	@Override
	public List<Seller> findAll() {
		List<Seller> sellers = new ArrayList<Seller>();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM SELLER ORDER BY SELLER_NUMBER");

             ResultSet rs = pStat.executeQuery()) {

             while(rs.next()) {
                Seller seller = new Seller();
                
                seller.setSellerNumber(rs.getInt("SELLER_NUMBER"));
                seller.setSellerId(rs.getString("SELLER_ID"));
                seller.setPassword(rs.getString("PASSWORD"));
                seller.setName(rs.getString("NAME"));
                seller.setPostalCode(rs.getString("POSTAL_CODE"));
                seller.setStreetAddress(rs.getString("STREET_ADDRESS"));
                seller.setAddressDetail(rs.getString("ADDRESS_DETAIL"));
                seller.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                seller.setEmail(rs.getString("EMAIL"));
                seller.setCompanyName(rs.getString("COMPANY_NAME"));

                sellers.add(seller);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellers;
	}

	@Override
	public Seller findById(String sellerId){
		Seller seller = null;

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM SELLER WHERE SELLER_ID = ?")) {
        	
            pStat.setString(1, sellerId);
            ResultSet rs = pStat.executeQuery();

            if(rs.next()) {
            	seller = new Seller();
            	
            	seller.setSellerNumber(rs.getInt("SELLER_NUMBER"));
                seller.setSellerId(rs.getString("SELLER_ID"));
                seller.setPassword(rs.getString("PASSWORD"));
                seller.setName(rs.getString("NAME"));
                seller.setPostalCode(rs.getString("POSTAL_CODE"));
                seller.setStreetAddress(rs.getString("STREET_ADDRESS"));
                seller.setAddressDetail(rs.getString("ADDRESS_DETAIL"));
                seller.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                seller.setEmail(rs.getString("EMAIL"));
                seller.setCompanyName(rs.getString("COMPANY_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seller;
	}

	@Override
	public void update(Seller seller) {
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE SELLER SET PASSWORD =?, NAME = ?, POSTAL_CODE = ? , STREET_ADDRESS = ?,"
    					+ "ADDRESS_DETAIL = ?, PHONE_NUMBER = ?, EMAIL = ?, COMPANY_NAME = ?"
    					+ "WHERE SELLER_ID = ?")){ 
    			
    		
    			
    			pStatement.setString(1, seller.getPassword());    		
    			pStatement.setString(2, seller.getName());
    			pStatement.setString(3, seller.getPostalCode());
    			pStatement.setString(4, seller.getStreetAddress());
    			pStatement.setString(5, seller.getAddressDetail());
    			pStatement.setString(6, seller.getPhoneNumber());
    			pStatement.setString(7, seller.getEmail());
    			pStatement.setString(8, seller.getCompanyName());
    			pStatement.setString(9, seller.getSellerId());

    			pStatement.executeUpdate();
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
	}

//	@Override
//	public void deleteById(int seller_number) {
//		try (Connection connection = DataSource.getDataSource();
//				 PreparedStatement preparedStatement
//						 = connection.prepareStatement("DELETE FROM SELLER WHERE SELLER_NUMBER = ?")) {
//				preparedStatement.setInt(1, seller_number);
//				preparedStatement.executeUpdate();
//			
//			}
//			catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
	@Override
	public void deleteById(String sellerId) {
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement preparedStatement
				= connection.prepareStatement("DELETE FROM SELLER WHERE SELLER_ID = ?")) {
			preparedStatement.setString(1, sellerId);
			preparedStatement.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
}
