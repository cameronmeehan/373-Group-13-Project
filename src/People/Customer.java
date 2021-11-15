package People;

import java.math.BigInteger;

import Tangibles.GroceryStore;

public class Customer extends Person {

	private String creditCardNumber;
	
	public Customer() {
		GroceryStore.CustomerList.add(this);
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String l) {
		int length = l.length();
		
		if (length == 16) {
			this.creditCardNumber = l;
		}
		
		if(length < 16) {
			System.out.println("This credit card number is invalid, card number is not long enough.");	
		}
		
		if(length > 16) {
			System.out.println("This credit card number is invalid, card number is too long.");
		}
	}

	
}
