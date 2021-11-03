package People;

import Tangibles.GroceryStore;

public class Customer extends Person {

	private int creditCardNumber;
	
	public Customer() {
		GroceryStore.CustomerList.add(this);
	}
	
	public void goToOnlineCheckout() {
		
		//brings customer to online checkout page?
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
}
