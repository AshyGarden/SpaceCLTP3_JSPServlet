package jy.servlet;

public class Product {
	private int productNumber;
	private int price;
	private String name;
	private String category;
	private String description;
	private int discountPercentage;
	private Seller seller;

	public Product() {}
	
	public Product(int productNumber, int price, String name, String category, String description,
			int discountPercentage, Seller seller) {
		this.productNumber = productNumber;
		this.price = price;
		this.name = name;
		this.category = category;
		this.description = description;
		this.discountPercentage = discountPercentage;
		this.seller = seller;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
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

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
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
				+ category + ", description=" + description + ", discountPercentage=" + discountPercentage + ", seller="
				+ seller + "]";
	}

	
	

}
