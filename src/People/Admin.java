package People;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Tangibles.GroceryStore;
import Tangibles.InventoryItem;
// test comment
public class Admin extends Person implements java.io.Serializable  {

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
		if(GroceryStore.EmployeeList.size() == 0) {
			Employee E = new Employee();
			E.setName(aName);

			System.out.println(aName + " was successfully hired");
			return(aName + " was successfully hired");
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
		}
		if(GroceryStore.EmployeeList.size() == 0) {
			return("No employees worka the grocery store.");
		}
		//if for loop is not executed
		return("Error occured in firing employee.");
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

				System.out.println(item + " was successfully added.");
				return(item + " was successfully added.");
			}
		}
		if(GroceryStore.InventoryList.size() == 0) {
			InventoryItem I = new InventoryItem();
			I.setName(item);

			System.out.println(item + " was successfully added.");
			return(item + " was successfully added.");
		}
		return("Error occured in adding inventory item.");
	}
	
	public String removeInventory(String item) {
		for (int i = 0; i < GroceryStore.InventoryList.size(); i++) {
			if (GroceryStore.InventoryList.get(i).getName().equals(item)) {
				GroceryStore.InventoryList.remove(i);
				System.out.println(item + " was successfully removed.");
				return(item + " was successfully removed.");
			}
			else {
				System.out.println(item + " cannot be removed because the item is not in the Grocery Store.");
				return(item + " cannot be removed because the item is not in the Grocery Store.");
			}
		}
		if(GroceryStore.InventoryList.size() == 0) {
			return("There are no inventory items in this store.");
		}
		return("Error occured in removing inventory item.");
	}
	
	public ArrayList<InventoryItem> topSale(){
		
		ArrayList<Integer> occurences = new ArrayList<Integer>();
		
		ArrayList<InventoryItem> tempList = new ArrayList<InventoryItem>();
		ArrayList<InventoryItem> topList = new ArrayList<InventoryItem>();
		
		//get list of all types Inventory Items sold
		for(int i = 0; i < GroceryStore.CheckoutList.size(); i++) {
			
			if(GroceryStore.CheckoutList.get(i).getSaleCompleted() == true) {
				
				for(int j = 0; j< GroceryStore.CheckoutList.get(i).getCartList().size(); j++) {
					
					if(tempList.contains(GroceryStore.CheckoutList.get(i).getCartList().get(j)) == false) {
						
						tempList.add(GroceryStore.CheckoutList.get(i).getCartList().get(j));
					}
				}				
			}	
		}
		
		//set occurences list with amount of accurences of each item
		for(int k = 0; k < tempList.size(); k++) {
		
			for(int i = 0; i < GroceryStore.CheckoutList.size(); i++) {
			
				if(GroceryStore.CheckoutList.get(i).getSaleCompleted() == true) {
					occurences.add(Collections.frequency(GroceryStore.CheckoutList.get(i).getCartList(), tempList.get(k)));
				}
			}
		}
		//setting top list
		if(tempList.size() <= 5) {
		for(int i = 0; i < 5; i++) {
			int tempI;
			tempI = Collections.max(occurences);
			tempI = occurences.indexOf(tempI);
			topList.add(tempList.get(tempI));
			tempList.remove(tempI);
		}
		}
		
		return(topList);
	}
}
