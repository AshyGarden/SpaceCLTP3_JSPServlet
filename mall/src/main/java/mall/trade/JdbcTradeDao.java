package mall.trade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jy.servlet.Product;
import mall.global.DataSource;
import mall.history.History;

public class JdbcTradeDao implements TradeDao{

	@Override
	public void insert(Trade trade) {
		// TODO Auto-generated method stub
		try(Connection connection = DataSource.getDataSource()){
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TRADE "
					+ "(PRODUCT_COUNT, TRADE_TIME, HISTORY_NUMBER, PRODUCT_NUMBER) "
					+ "VALUES (?,?,?,?)");
			preparedStatement.setInt(1, trade.getProduct_count());
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(History history) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trade findByHistoryNumber(History history) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trade findByProductNumber(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
