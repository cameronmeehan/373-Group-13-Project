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

//possible added feature, GroceryStore.java holds int of balance and money is added when sales are made
//money would have to be removed from balance when inventory is added to stock by employee

//This is our in Person and online Checkout class
public class Checkout implements java.io.Serializable  {
	private double discount;
	private boolean saleCompleted; // needed for working with checkout objects later
	private ArrayList<InventoryItem> CartList = new ArrayList<InventoryItem>(); // list of objects added to cart to purchase
	
	public Checkout() {
		GroceryStore.CheckoutList.add(this);
		saleCompleted = false;
	}
	
	public boolean getSaleCompleted() {
		return(saleCompleted);
	}
	
	public void addItemToCart (InventoryItem aItem) {
		CartList.add(aItem);
	}
	
	public ArrayList<InventoryItem> getCartList() {
		return(CartList);
	}
	public void removeItem (InventoryItem aItem ) {
		CartList.remove(aItem);
	}
	
	public void applyDiscount (double discount, double price) {
		this.discount = price / (this.discount * .01);
		price = price - this.discount;
	}
	
	//finish checkout
	public void checkout () {
		for(int i = 0; i < GroceryStore.InventoryList.size(); i++) {
			
			if(CartList.contains(GroceryStore.InventoryList.get(i))){
				GroceryStore.InventoryList.get(i).decreaseStock(1);
				System.out.println(GroceryStore.InventoryList.get(i).getName() + " was purchased at " + GroceryStore.InventoryList.get(i).getPrice() + "$." );
			}
			
			
		}
		saleCompleted = true;
		
	}
}

