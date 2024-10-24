package mall.younghun;

public class History {
	private int history_number;
	private Buyer buyer;
	
	public History() {
		
	}
	
	public History(int history_number, Buyer buyer) {
		super();
		this.history_number = history_number;
		this.buyer = buyer;
	}

	public int getHistory_number() {
		return history_number;
	}

	public void setHistory_number(int history_number) {
		this.history_number = history_number;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	@Override
	public String toString() {
		return "History [history_number=" + history_number + ", buyer=" + buyer + "]";
	}
	
	
	
	
}
