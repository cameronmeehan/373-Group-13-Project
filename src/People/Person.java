package People;

import java.math.BigInteger;

public class Person implements java.io.Serializable  {

	protected String name;
	protected String address;
	protected String phoneNumber;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNum) {

		if ( phoneNum.length() == 10 ) {
			this.phoneNumber = phoneNum;
		}
		if (phoneNum.length() < 10) {
			System.out.println("This phone number is invalid, phone number is not long enough");
		}
		if (phoneNum.length() > 10) {
			System.out.println("This phone number is invalid, phone number is too long");
		}
	}
	
	
}
