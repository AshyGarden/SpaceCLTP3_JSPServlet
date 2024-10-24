package jy.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSellerDao implements SellerDao{

	@Override   
	public void insert(Seller seller) {
		try(Connection connection = DataSource.getDataSource();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SELLER " +
	                    "(SELLER_ID, PASSWORD, NAME, POSTAL_CODE, STREET_ADDRESS, ADDRESS_DETAIL, PHONE_NUMBER, EMAIL,COMPANY_NAME) VALUES (?,?,?,?,?,?,?,?,?)"))
	        {

	            preparedStatement.setString(1, seller.seller_id);
	            preparedStatement.setString(2, seller.password);
	            preparedStatement.setString(3, seller.name);
	            preparedStatement.setString(4, seller.postal_code);
	            preparedStatement.setString(5, seller.street_address);
	            preparedStatement.setString(6, seller.address_detail);
	            preparedStatement.setString(7, seller.phone_number);
	            preparedStatement.setString(8, seller.email);
	            preparedStatement.setString(9, seller.company_name);
	            

	            preparedStatement.executeUpdate();

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
                
                seller.setSeller_number(rs.getInt("SELLER_NUMBER"));
                seller.setSeller_id(rs.getString("SELLER_ID"));
                seller.setPassword(rs.getString("PASSWORD"));
                seller.setName(rs.getString("NAME"));
                seller.setPostal_code(rs.getString("POSTAL_CODE"));
                seller.setStreet_address(rs.getString("STREET_ADDRESS"));
                seller.setAddress_detail(rs.getString("ADDRESS_DETAIL"));
                seller.setPhone_number(rs.getString("PHONE_NUMBER"));
                seller.setEmail(rs.getString("EMAIL"));
                seller.setCompany_name(rs.getString("COMPANY_NAME"));

                sellers.add(seller);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellers;
	}

	@Override
	public Seller findById(int seller_number) {
		Seller seller = new Seller();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM SELLER WHERE SELLER_NUMBER = ?")) {
        	
            pStat.setInt(1, seller_number);
            ResultSet rs = pStat.executeQuery();

            if(rs.next()) {
            	
            	seller.setSeller_number(rs.getInt("SELLER_NUMBER"));
                seller.setSeller_id(rs.getString("SELLER_ID"));
                seller.setPassword(rs.getString("PASSWORD"));
                seller.setName(rs.getString("NAME"));
                seller.setPostal_code(rs.getString("POSTAL_CODE"));
                seller.setStreet_address(rs.getString("STREET_ADDRESS"));
                seller.setAddress_detail(rs.getString("ADDRESS_DETAIL"));
                seller.setPhone_number(rs.getString("PHONE_NUMBER"));
                seller.setEmail(rs.getString("EMAIL"));
                seller.setCompany_name(rs.getString("COMPANY_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seller;
	}

	@Override
	public void update(Seller seller) {
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE SELLER SET SELLER_ID = '?', PASSWORD ='?', NAME = '?', POSTAL_CODE = '?' , STREET_ADDRESS = '?', \r\n"
    					+ "ADDRESS_DETAIL = '?', PHONE_NUMBER = '?', EMAIL = '?', COMPANY_NAME = '?'\r\n"
    					+ "WHERE SELLER_NUMBER = ?")){ 
    			
    		
    			pStatement.setString(1, seller.seller_id);
    			pStatement.setString(2, seller.password);    		
    			pStatement.setString(3, seller.name);
    			pStatement.setString(4, seller.postal_code);
    			pStatement.setString(5, seller.street_address);
    			pStatement.setString(6, seller.address_detail);
    			pStatement.setString(7, seller.phone_number);
    			pStatement.setString(8, seller.email);
    			pStatement.setString(9, seller.company_name);
    			pStatement.setInt(10, seller.seller_number);

    			pStatement.executeUpdate();
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(int seller_number) {
		try (Connection connection = DataSource.getDataSource();
				 PreparedStatement preparedStatement
						 = connection.prepareStatement("DELETE FROM SELLER WHERE SELLER_NUMBER = ?")) {
				preparedStatement.setInt(1, seller_number);
				preparedStatement.executeUpdate();
			
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
}
