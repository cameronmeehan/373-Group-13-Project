package People;

import Tangibles.GroceryStore;

public class Employee extends Person{

	
	public Employee() {
		GroceryStore.EmployeeList.add(this);
	}
}
