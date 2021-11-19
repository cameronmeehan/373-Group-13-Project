package People;

import Tangibles.GroceryStore;

public class Employee extends Person implements java.io.Serializable {
	
	//need to set all fields
	private double hourlyRate;
	
	public Employee() {
		GroceryStore.EmployeeList.add(this);
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	
}
