package mall.trade;

import java.sql.Timestamp;

import jy.servlet.Product;
import mall.history.History;

public class Trade {
	private int trade_number;
	private int product_count;
	private Timestamp trade_time;
	private History history;
	private Product product;
	
	public Trade() {
		
	}

	public Trade(int trade_number, int product_count, Timestamp trade_time, History history, Product product) {
		super();
		this.trade_number = trade_number;
		this.product_count = product_count;
		this.trade_time = trade_time;
		this.history = history;
		this.product = product;
	}

	public int getTrade_number() {
		return trade_number;
	}

	public void setTrade_number(int trade_number) {
		this.trade_number = trade_number;
	}

	public int getProduct_count() {
		return product_count;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public Timestamp getTrade_time() {
		return trade_time;
	}

	public void setTrade_time(Timestamp trade_time) {
		this.trade_time = trade_time;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Trade [trade_number=" + trade_number + ", product_count=" + product_count + ", trade_time=" + trade_time
				+ ", history=" + history + ", product=" + product + "]";
	}
	
	
	
}
