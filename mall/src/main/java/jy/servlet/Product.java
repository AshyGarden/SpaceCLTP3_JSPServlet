package jy.servlet;

public class Product {
	int product_number;
	int price;
	String name;
	String category;
	String description;
	int discount_percentage;
	Seller seller;
	
	public Product() {}
	
	public Product(int product_number, int price, String name, String category, String description,
			int discount_percentage, Seller seller) {
		super();
		this.product_number = product_number;
		this.price = price;
		this.name = name;
		this.category = category;
		this.description = description;
		this.discount_percentage = discount_percentage;
		this.seller = seller;
	}

	public int getProduct_number() {
		return product_number;
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(int discount_percentage) {
		this.discount_percentage = discount_percentage;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [product_number=" + product_number + ", price=" + price + ", name=" + name + ", category="
				+ category + ", description=" + description + ", discount_percentage=" + discount_percentage
				+ ", seller=" + seller + "]";
	}
	
	

}
