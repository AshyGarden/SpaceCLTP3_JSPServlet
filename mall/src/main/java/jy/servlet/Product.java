package jy.servlet;

public class Product {
	int productNumber;
	int price;
	String name;
	String category;
	String description;
	int discountPercentage;
	Seller seller;
	
	public Product() {}
	
	public Product(int productNumber, int price, String name, String category, String description,
			int discountPercentage, Seller seller) {
		super();
		this.productNumber = productNumber;
		this.price = price;
		this.name = name;
		this.category = category;
		this.description = description;
		this.discountPercentage = discountPercentage;
		this.seller = seller;
	}

	public int getProduct_number() {
		return productNumber;
	}

	public void setProduct_number(int productNumber) {
		this.productNumber = productNumber;
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
		return discountPercentage;
	}

	public void setDiscount_percentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [productNumber=" + productNumber + ", price=" + price + ", name=" + name + ", category="
				+ category + ", description=" + description + ", discount_percentage=" + discountPercentage
				+ ", seller=" + seller + "]";
	}
	
	

}
