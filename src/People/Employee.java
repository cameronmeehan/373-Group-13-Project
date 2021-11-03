package People;

import Tangibles.GroceryStore;

public class Employee extends Person{
	
	//need to set all fields
	private int hourlyRate;
	
	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public Employee() {
		GroceryStore.EmployeeList.add(this);
	}
}
