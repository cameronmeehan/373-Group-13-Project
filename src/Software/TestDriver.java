package Software;


import People.Admin;
import People.Customer;
import People.Employee;
import Tangibles.Dairy;
import Tangibles.GroceryStore;
import java.math.BigInteger;

//this can be used to test program functions without a GUI being initialized
public class TestDriver {
	public static void main(String[] args) 
	{
				System.out.println("Initializing Admin, Employees and Customers for testing.");
				
				//initializing admin
				Admin A1 = new Admin();
				A1.setUsername("admin");
				A1.setPassword("Password");
				GroceryStore.AdminList.add(A1);
				
				//making employees for testing
				Employee E1 = new Employee();
				E1.setName("tom");
				E1.setPassword("1234");
				E1.setUsername("tom");
				E1.setHourlyRate(12);
				
				Employee E2 = new Employee();
				E2.setName("tommy");
				E2.setPassword("1234");
				E2.setUsername("tommy");
				E2.setHourlyRate(15);
				
				//making customer for testing
				Customer C1 = new Customer();
				C1.setUsername("pat");
				C1.setPassword("1234");
				C1.setName("pat");
				
				Customer C2 = new Customer();
				C1.setUsername("patty");
				C1.setPassword("1234");
				C1.setName("patty");
								
				//making person for checking phone number exceptions
				Customer C5 = new Customer();
				C5.setUsername("paul");
				C5.setPassword("4321");
				C5.setName("paul");
				C5.setCreditCardNumber("1111222233334444");
				
				//making InventoryItem for testing
				Dairy I1 = new Dairy();
				I1.setName("Whole Milk");
				I1.setStock(10);
				I1.setMilk(true);
				I1.setPrice(3.5);
				
				System.out.println("\nTesting hiring an Employee that has already been hired.");
				//testing exception of hiring an employee that has already been hired
				A1.hireEmployee("tom");
				

				System.out.println("\nTesting firing an Employee that does not work at the store.");
				//testing exception of firing an employee that does not work at the store
				A1.fireEmployee("Sarah");
				
				System.out.println("\nTesting adding an inventory item to the store.");
				A1.addInventory("Salmon");
				
				System.out.println("\nTesting adding an existing inventory item to the store.");
				A1.addInventory("Whole Milk");
				
				System.out.println("\nTesting removing an inventory item in the store.");
				A1.removeInventory("Whole Milk");
				
				System.out.println("\nTesting removing an inventory item that is not in the store.");
				A1.removeInventory("Peanut Butter");
				
				System.out.println("\nTesting setting a Persons phone number to a number over range.");
				C5.setPhoneNumber("1234567890123");
				
				System.out.println("\nTesting setting a Persons phone number to a number under range");
				C5.setPhoneNumber("12345678");
				
				System.out.println("\nTesting setting a Customers credit card number to a number over range");
				C5.setCreditCardNumber("12345678901234567");
				
				System.out.println("\nTesting setting a Customers credit card number to a number under range");
				C5.setCreditCardNumber("123456789012");
				
	}
}
