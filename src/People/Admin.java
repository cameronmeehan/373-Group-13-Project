package People;

import Tangibles.GroceryStore;
import Tangibles.InventoryItem;
// test comment
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

				System.out.println(aName + " was successfully hired");
				return(aName + " was successfully hired");
		
		
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
				return(aName + " was fired successfully");
				
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
	
	public String addInventory(String item) {
		for (int i = 0; i < GroceryStore.InventoryList.size(); i++) {
			if(GroceryStore.InventoryList.get(i).getName().equals(item)) {
				System.out.println(item + " cannot be added because the item is already in the Grocery Store.");
				return(item + " cannot be added because the item is already in the Grocery Store.");
			}
			
			else {
				InventoryItem I = new InventoryItem();
				I.setName(item);

				System.out.println(item + " was successfully added");
				return(item + " was successfully added");
			}
		}
		return("Error occured in adding inventory item.");
	}
	
}
