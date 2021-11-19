package Software;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import People.Admin;
import People.Customer;
import People.Employee;
import People.Person;
import Tangibles.Dairy;
import Tangibles.DryGoods;
import Tangibles.GroceryStore;
import Tangibles.InventoryItem;
import Tangibles.Meat;
import Tangibles.Produce;

//This is our in Person and online Checkout class
public class Checkout implements java.io.Serializable  {
	private double discount;
	private ArrayList<InventoryItem> CartList = new ArrayList<InventoryItem>();
	
	public Checkout() {
		GroceryStore.CheckoutList.add(this);
	}
	
	public void addItemToCart (InventoryItem aItem) {
		CartList.add(aItem);
	}
	
	public void removeItem (InventoryItem aItem ) {
		CartList.remove(aItem);
	}
	
	public void applyDiscount (double discount, double price) {
		this.discount = price / (this.discount * .01);
		price = price - this.discount;
	}
	
	public void checkout () {
		for(int i = 0; i < GroceryStore.InventoryList.size(); i++) {
			
			if(CartList.contains(GroceryStore.InventoryList.get(i))){
				GroceryStore.InventoryList.get(i).decreaseStock(1);
				System.out.println(GroceryStore.InventoryList.get(i).getName() + " was purchased at " + GroceryStore.InventoryList.get(i).getPrice() + "$." );
			}
			
			
		}
		
	}
}

