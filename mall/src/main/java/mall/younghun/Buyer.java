package mall.younghun;

public class Buyer {
	private int buyer_number;
	private String buyer_id;
	private String password;
	private String name;
	private String postal_code;
	private String street_address;
	private String address_detail;
	private String phone_number;
	private String email;
	
	
	
	public Buyer() {
		super();
	}



	public Buyer(int buyer_number, String buyer_id, String password, String name, String postal_code,
			String street_address, String address_detail, String phone_number, String email) {
		super();
		this.buyer_number = buyer_number;
		this.buyer_id = buyer_id;
		this.password = password;
		this.name = name;
		this.postal_code = postal_code;
		this.street_address = street_address;
		this.address_detail = address_detail;
		this.phone_number = phone_number;
		this.email = email;
	}



	public int getBuyer_number() {
		return buyer_number;
	}



	public void setBuyer_number(int buyer_number) {
		this.buyer_number = buyer_number;
	}



	public String getBuyer_id() {
		return buyer_id;
	}



	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	@Override
	public String toString() {
		return "Buyer [buyer_number=" + buyer_number + ", buyer_id=" + buyer_id + ", password=" + password + ", name="
				+ name + ", postal_code=" + postal_code + ", street_address=" + street_address + ", address_detail="
				+ address_detail + ", phone_number=" + phone_number + ", email=" + email + "]";
	}
	
	

}
