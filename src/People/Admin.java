package People;

import Tangibles.GroceryStore;

public class Admin extends Person {

	public String hireEmployee(String aName) {
		for(int i = 0; i < GroceryStore.EmployeeList.size(); i++) {
			if(GroceryStore.EmployeeList.get(i).getName().equals(aName)) {
				System.out.println(aName + " cannot be hired because they are already employed by the Grocery Store.");
				return(aName + " cannot be hired because they are already employed by the Grocery Store.");
			}
			
			else {
				Employee E = new Employee();
				E.setName(aName);

				System.out.println(aName + " was succsesfully hired");
				return(aName + " was succsesfully hired");
		
		
			}
		}
		//if for loop is not executed
		return("Error occured in hiring employee.");
	}
	
	public String fireEmployee(String aName) {
		for(int i = 0; i < GroceryStore.EmployeeList.size(); i++) {
			if(GroceryStore.EmployeeList.get(i).getName().equals(aName)) {
				
				GroceryStore.EmployeeList.remove(i);
				
				System.out.println(aName + " was fired succsesfully");
				return(aName + " was fired succsesfully");
				
			}
			
			else {

				System.out.println(aName + " does not work at the Grocery Store and could not be fired.");
				return(aName + " does not work at the Grocery Store and could not be fired.");
		
		
			}
			
			
//			for(int i = 0; i < GroceryStore.EmployeeList.size(); i++){
//				if(GroceryStore.EmployeeList.get(i).getName().equals(fireName.getText())) {
//					
//					GroceryStore.EmployeeList.remove(i);
//					
//					remove(employeeInfo);
//					EmployeeScroll.setViewportView(ListFromArrayEmployee(GroceryStore.EmployeeList));
//					add(employeeInfo);
//				}
//			}
		}
		//if for loop is not executed
		return("Error occured in hiring employee.");
	}
	

}
