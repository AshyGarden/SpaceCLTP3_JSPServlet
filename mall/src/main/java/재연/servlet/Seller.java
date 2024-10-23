package Àç¿¬.servlet;

public class Seller {
	int seller_number;
	String seller_id;
	String name;   
	String password;
	String postal_code;
	String street_address;
	String address_detail;
	String phone_number;
	String email;
	String company_name;
	
	public Seller() {}
	
	public Seller(int seller_number, String seller_id, String name, String password, String postal_code,
			String street_address, String address_detail, String phone_number, String email, String company_name) {
		this.seller_number = seller_number;
		this.seller_id = seller_id;
		this.name = name;
		this.password = password;
		this.postal_code = postal_code;
		this.street_address = street_address;
		this.address_detail = address_detail;
		this.phone_number = phone_number;
		this.email = email;
		this.company_name = company_name;
	}

	public int getSeller_number() {
		return seller_number;
	}

	public void setSeller_number(int seller_number) {
		this.seller_number = seller_number;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
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

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	@Override
	public String toString() {
		return "Seller [seller_number=" + seller_number + ", seller_id=" + seller_id + ", name=" + name + ", password="
				+ password + ", postal_code=" + postal_code + ", street_address=" + street_address + ", address_detail="
				+ address_detail + ", phone_number=" + phone_number + ", email=" + email + ", company_name="
				+ company_name + "]";
	}
	
}
