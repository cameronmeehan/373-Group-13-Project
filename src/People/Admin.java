package People;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Tangibles.GroceryStore;
import Tangibles.InventoryItem;
// test comment
public class Admin extends Person implements java.io.Serializable  {

	public Admin() {
		GroceryStore.AdminList.add(this);
	}
		
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
	
	//finds top 5 selling items 
	public ArrayList<InventoryItem> topSale(){
		
		
		ArrayList<Integer> occurences = new ArrayList<Integer>();
		ArrayList<InventoryItem> tempList = new ArrayList<InventoryItem>();
		ArrayList<InventoryItem> topList = new ArrayList<InventoryItem>();
		
		//run through all checkout lists
		for(int i = 0; i < GroceryStore.CheckoutList.size(); i++) {
			
			
			if(GroceryStore.CheckoutList.get(i).getSaleCompleted() == true) {
				
				// run through all cart lists
				for(int j = 0; j< GroceryStore.CheckoutList.get(i).getCartList().size(); j++) {
					
						//adding to templist and occurance list when it is first one in list
						if(tempList.contains(GroceryStore.CheckoutList.get(i).getCartList().get(j)) == false) {
							tempList.add(GroceryStore.CheckoutList.get(i).getCartList().get(j));
							occurences.add(GroceryStore.CheckoutList.get(i).getQuantity(GroceryStore.CheckoutList.get(i).getCartList().get(j)));
							
						}
						//adding to accurance list when there is a matching item
						else {
							//find index of matching element
							
							int temp = occurences.get(tempList.indexOf(GroceryStore.CheckoutList.get(i).getCartList().get(j)));
							temp = temp + GroceryStore.CheckoutList.get(i).getQuantity(GroceryStore.CheckoutList.get(i).getCartList().get(j));
							occurences.set(tempList.indexOf(GroceryStore.CheckoutList.get(i).getCartList().get(j)), temp);
							
						}
					}
				}				
			}	
		
		
		
		//setting top list
		if(tempList.size() >= 5) {
		for(int i = 0; i < 5; i++) {
			int tempI;
			tempI = Collections.max(occurences);
			tempI = occurences.indexOf(tempI);
			topList.add(tempList.get(tempI));
			tempList.remove(tempI);
			occurences.remove(tempI);
		}
		}
		
		return (topList);
	}

	//gets total quantity of an item sold, from all checkouts
	public int getQuantitySold(InventoryItem aItem) {
		int quantity;
		
		ArrayList<Integer> occurences = new ArrayList<Integer>();
		ArrayList<InventoryItem> tempList = new ArrayList<InventoryItem>();
		
		//run through all checkout lists
		for(int i = 0; i < GroceryStore.CheckoutList.size(); i++) {
			
			
			if(GroceryStore.CheckoutList.get(i).getSaleCompleted() == true) {
				
				// run through all cart lists
				for(int j = 0; j< GroceryStore.CheckoutList.get(i).getCartList().size(); j++) {
					
						//adding to templist and occurance list when it is first one in list
						if(tempList.contains(GroceryStore.CheckoutList.get(i).getCartList().get(j)) == false) {
							tempList.add(GroceryStore.CheckoutList.get(i).getCartList().get(j));
							occurences.add(GroceryStore.CheckoutList.get(i).getQuantity(GroceryStore.CheckoutList.get(i).getCartList().get(j)));
							
						}
						//adding to accurance list when there is a matching item
						else {
							//find index of matching element
							
							int temp = occurences.get(tempList.indexOf(GroceryStore.CheckoutList.get(i).getCartList().get(j)));
							temp = temp + GroceryStore.CheckoutList.get(i).getQuantity(GroceryStore.CheckoutList.get(i).getCartList().get(j));
							occurences.set(tempList.indexOf(GroceryStore.CheckoutList.get(i).getCartList().get(j)), temp);
							
						}
					}
				}				
			}
		quantity = occurences.get(tempList.indexOf(aItem));
		
		return quantity;
	}

	//gets sales info about an item, returns string
	public String getSalesInfo(String aItemName) {
		InventoryItem tempItem = null;
		for(int i = 0; i < GroceryStore.InventoryList.size(); i++) {
			if(GroceryStore.InventoryList.get(i).getName().equals(aItemName)) {
				tempItem = GroceryStore.InventoryList.get(i);
			}
		}
		
		
		return(aItemName +" sold " + getQuantitySold(tempItem) + " times at " + tempItem.getPrice() + "$. " + tempItem.getStock() + " currently in stock." );
	}

	//finds the total money made on all checkouts
	public double totalSalesCalc() {
		double temp = 0;
		
		for(int i = 0; i < GroceryStore.CheckoutList.size(); i++) {
			if(GroceryStore.CheckoutList.get(i).getSaleCompleted() == true) {
			temp = temp + GroceryStore.CheckoutList.get(i).getCheckoutCost();
			}
		}
		
		return(temp);
	}
}
