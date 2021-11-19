package Tangibles;

import java.util.ArrayList;
import java.io.*;

import People.Admin;
import People.Customer;
import People.Employee;
import People.Person;
import Software.Checkout;


public class GroceryStore implements java.io.Serializable {
	
	public static ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	public static ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
	public static ArrayList<Admin> AdminList = new ArrayList<Admin>();
	public static ArrayList<InventoryItem> InventoryList = new ArrayList<InventoryItem>();
	public static ArrayList<Checkout> CheckoutList = new ArrayList<Checkout>();
}
