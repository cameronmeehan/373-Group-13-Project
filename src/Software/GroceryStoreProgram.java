package Software;

import People.Admin;
import People.Customer;
import People.Employee;
import Tangibles.GroceryStore;

//This class initializes the Program and opens up the GUI
public class GroceryStoreProgram {
	public static void main(String[] args) {
		
		//testing
		Employee E1 = new Employee();
		Admin A1 = new Admin();
		Customer C1 = new Customer();
		
		E1.setUsername("timmy23");
		E1.setPassword("4321");
		A1.setUsername("albert65");
		A1.setPassword("9999");
		C1.setUsername("sally11");
		C1.setPassword("1234");
		
		GroceryStore.CustomerList.add(C1);
		GroceryStore.AdminList.add(A1);
		GroceryStore.EmployeeList.add(E1);
		//testing end
		
		
		new GroceryStoreProgramGUI();
	}

}
