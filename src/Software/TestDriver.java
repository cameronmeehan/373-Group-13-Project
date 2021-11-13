package Software;

import People.Admin;
import People.Customer;
import People.Employee;
import Tangibles.Dairy;
import Tangibles.GroceryStore;

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
				
				
				
	}
}
