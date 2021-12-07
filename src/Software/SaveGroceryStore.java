package Software;

import java.util.ArrayList;

import People.Admin;
import People.Customer;
import People.Employee;
import Tangibles.InventoryItem;

public class SaveGroceryStore implements java.io.Serializable  {

	// this is a class to temporarily save the grocery store program, it is necsasary because the fields in GroceryStore are static
	public ArrayList<Customer> tempCustomerList = new ArrayList<Customer>();
	public ArrayList<Employee> tempEmployeeList = new ArrayList<Employee>();
	public ArrayList<Admin> tempAdminList = new ArrayList<Admin>();
	public ArrayList<InventoryItem> tempInventoryList = new ArrayList<InventoryItem>();
	public ArrayList<Checkout> tempCheckoutList = new ArrayList<Checkout>();
	

}
