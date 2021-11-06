package People;

import java.math.BigInteger;

import Tangibles.GroceryStore;

public class Customer extends Person {

	private Long creditCardNumber;
	
	public Customer() {
		GroceryStore.CustomerList.add(this);
	}

	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
}
