package People;

import java.math.BigInteger;

public class Person {

	protected String name;
	protected String address;
	protected Long phoneNumber;
	protected String password;
	protected String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNum) {
		int length =  String.valueOf(phoneNum).length();

		if ( length == 10 ) {
			this.phoneNumber = phoneNum;
		}
		if (length < 10) {
			System.out.println("This phone number is invalid, phone number is not long enough");
		}
		if (length > 10) {
			System.out.println("This phone number is invalid, phone number is too long");
		}
	}
	
	
}
