package jy.servlet;

public class Seller {
	int sellerNumber;
	String sellerId;
	String name;   
	String password; 
	String postalCode;
	String streetAddress;
	String addressDetail;
	String phoneNumber;
	String email;
	String companyName;
	
	public Seller() {}

	public Seller(int sellerNumber, String sellerId, String name, String password, String postalCode,
			String streetAddress, String addressDetail, String phoneNumber, String email, String companyName) {
		super();
		this.sellerNumber = sellerNumber;
		this.sellerId = sellerId;
		this.name = name;
		this.password = password;
		this.postalCode = postalCode;
		this.streetAddress = streetAddress;
		this.addressDetail = addressDetail;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.companyName = companyName;
	}

	public int getSellerNumber() {
		return sellerNumber;
	}

	public void setSellerNumber(int sellerNumber) {
		this.sellerNumber = sellerNumber;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Seller [sellerNumber=" + sellerNumber + ", sellerId=" + sellerId + ", name=" + name + ", password="
				+ password + ", postalCode=" + postalCode + ", streetAddress=" + streetAddress + ", addressDetail="
				+ addressDetail + ", phoneNumber=" + phoneNumber + ", email=" + email + ", companyName=" + companyName
				+ "]";
	}
	
	
}