package Software;

import People.Admin;
import People.Customer;
import People.Employee;
import Tangibles.GroceryStore;

//This class initializes the Program and opens up the GUI
public class GroceryStoreProgram {
	public static void main(String[] args) {
		
		//initializing admin
		Admin A1 = new Admin();
		A1.setUsername("admin");
		A1.setPassword("password");
		GroceryStore.AdminList.add(A1);
		
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
		
		new GroceryStoreProgramGUI();
	}

}
