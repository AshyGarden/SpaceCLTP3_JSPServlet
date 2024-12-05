package mall.trade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jy.servlet.Product;
import mall.global.DataSource;
import mall.history.History;

public class JdbcTradeDao implements TradeDao{

	@Override
	public void insert(Trade trade) {
		// TODO Auto-generated method stub
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TRADE "
					+ "(PRODUCT_COUNT, TRADE_TIME, HISTORY_NUMBER, PRODUCT_NUMBER) "
					+ "VALUES (?,CURRENT_TIMESTAMP,?,?)")){

			preparedStatement.setInt(1, trade.getProduct_count());
			preparedStatement.setInt(2, trade.getHistory().getHistory_number());
			preparedStatement.setInt(3, trade.getProduct().getProductNumber());
			preparedStatement.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(History history) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Trade> findByHistoryNumber(int history_number) {
		// TODO Auto-generated method stub
		
		List<Trade> tradelist = new ArrayList<>();
		try(Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TRADE WHERE HISTORY_NUMBER = ?")){
			preparedStatement.setInt(1, history_number);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				History history = new History();
				history.setHistory_number(history_number);
				Product product= new Product();
				product.setProductNumber(rs.getInt("PRODUCT_NUMBER"));
				Trade trade = new Trade();
				trade.setHistory(history);
				trade.setProduct_count(rs.getInt("PRODUCT_COUNT"));
				trade.setTrade_number(rs.getInt("TRADE_NUMBER"));
				trade.setTrade_time(rs.getTimestamp("TRADE_TIME"));
				trade.setProduct(product);
				
				tradelist.add(trade);
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tradelist;
	}

	@Override
	public List<Trade> findByProductNumber(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
