package People;

import java.math.BigInteger;

import Tangibles.GroceryStore;

public class Customer extends Person implements java.io.Serializable {

	private String creditCardNumber;
	
	public void Customer() {
		GroceryStore.CustomerList.add(this);
		
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String l) {
		
		this.creditCardNumber = l;
		
	}
	
	//checking credit card number for correct length
	public static boolean checkCreditCardNumber(String t) {
		int length = t.length();
		
		
		if(length == 16) {
			return(true);
		}
		
		else {
			return(false);
		}
	}
	
}
