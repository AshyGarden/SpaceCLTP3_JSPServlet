package mall.younghun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mall.common.DataSource;

public class JdbcBuyerDao implements BuyerDao {

	@Override
	public void insert(Buyer buyer) {
		// TODO Auto-generated method stub
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO BUYER "
					+ "(BUYER_ID, PASSWORD, NAME, POSTAL_CODE, STREET_ADDRESS, ADDRESS_DETAIL, PHONE_NUMBER, EMAIL) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)")){
			
			preparedStatement.setString(1, buyer.getBuyer_id());
			preparedStatement.setString(2, buyer.getPassword());
			preparedStatement.setString(3, buyer.getName());
			preparedStatement.setString(4, buyer.getPostal_code());
			preparedStatement.setString(5, buyer.getStreet_address());
			preparedStatement.setString(6, buyer.getAddress_detail());
			preparedStatement.setString(7, buyer.getPhone_number());
			preparedStatement.setString(8, buyer.getEmail());
			preparedStatement.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int buyer_number) {
		// TODO Auto-generated method stub
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM BUYER WHERE BUYER_NUMBER = ?")){
			preparedStatement.setInt(1, buyer_number);
			try {
			preparedStatement.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Buyer buyer) {
		// TODO Auto-generated method stub
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE BUYER SET BUYER_ID = ?, PASSWORD =?, "
					+ "NAME = ?, POSTAL_CODE = ? , STREET_ADDRESS = ?, "
					+ "ADDRESS_DETAIL = ?, PHONE_NUMBER = ?, EMAIL = ? "
					+ "WHERE BUYER_NUMBER = ?")){
			
			preparedStatement.setString(1, buyer.getBuyer_id());
			preparedStatement.setString(2, buyer.getPassword());
			preparedStatement.setString(3, buyer.getName());
			preparedStatement.setString(4, buyer.getPostal_code());
			preparedStatement.setString(5, buyer.getStreet_address());
			preparedStatement.setString(6, buyer.getAddress_detail());
			preparedStatement.setString(7, buyer.getPhone_number());
			preparedStatement.setString(8, buyer.getEmail());
			preparedStatement.setInt(9, buyer.getBuyer_number());
			preparedStatement.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Buyer findById(String buyer_id) {
		// TODO Auto-generated method stub
		Buyer buyer = null;
		try(Connection connection = DataSource.getDataSource()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BUYER WHERE BUYER_ID = ?");
			preparedStatement.setString(1, buyer_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				buyer = new Buyer();
				buyer.setBuyer_number(resultSet.getInt("BUYER_NUMBER"));
				buyer.setBuyer_id(resultSet.getString("BUYER_ID"));
				buyer.setPassword(resultSet.getString("PASSWROD"));
				buyer.setName(resultSet.getString("NAME"));
				buyer.setPostal_code(resultSet.getString("POSTAL_CODE"));
				buyer.setStreet_address(resultSet.getString("Street_Address"));
				buyer.setAddress_detail(resultSet.getString("ADDRESS_DETAIL"));
				buyer.setPhone_number(resultSet.getString("PHONE_NUMBER"));
				buyer.setEmail(resultSet.getString("EMAIL"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return buyer;
	}

	@Override
	public List<Buyer> findAll() {
		// TODO Auto-generated method stub
		List<Buyer> buyers = new ArrayList<>();
		try(Connection connection = DataSource.getDataSource()){
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BUYER ");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Buyer buyer = new Buyer();
				buyer.setBuyer_number(resultSet.getInt("BUYER_NUMBER"));
				buyer.setBuyer_id(resultSet.getString("BUYER_ID"));
				buyer.setPassword(resultSet.getString("PASSWROD"));
				buyer.setName(resultSet.getString("NAME"));
				buyer.setPostal_code(resultSet.getString("POSTAL_CODE"));
				buyer.setStreet_address(resultSet.getString("Street_Address"));
				buyer.setAddress_detail(resultSet.getString("ADDRESS_DETAIL"));
				buyer.setPhone_number(resultSet.getString("PHONE_NUMBER"));
				buyer.setEmail(resultSet.getString("EMAIL"));
				buyers.add(buyer);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return buyers;
	}
	
}
