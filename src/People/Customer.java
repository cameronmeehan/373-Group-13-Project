package People;

import java.math.BigInteger;

import Tangibles.GroceryStore;

public class Customer extends Person {

	private Long creditCardNumber;
	
	public Customer() {
		GroceryStore.CustomerList.add(this);
	}
	
	public void goToOnlineCheckout() {
		
		//brings customer to online checkout page?
	}

	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
}
