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
	private double discount = 0; // 0-100, percent representitive
	private double checkoutCost = 0; //final cost of sale
	private boolean saleCompleted; // needed for working with checkout objects later
	private ArrayList<InventoryItem> CartList = new ArrayList<InventoryItem>(); // list of objects added to cart to purchase
	private ArrayList<Integer> quantity = new ArrayList<Integer>(); // quantity of items, at same index as items in CartList
	
	public Checkout() {
		GroceryStore.CheckoutList.add(this);
		saleCompleted = false;
	}
	
	//returns if sale has been completed
	public boolean getSaleCompleted() {
		return(saleCompleted);
	}
	
	//add item by object or barcode
	public void addItemToCart(long abarcode) {
		for(int i= 0; i < GroceryStore.InventoryList.size(); i++) {
			if(GroceryStore.InventoryList.get(i).getBarcode() == abarcode) {
				addItemToCart(GroceryStore.InventoryList.get(i));
			}
		}
	}
	
	public void addItemToCart (InventoryItem aItem) {
		int temp;
		int current =0;

		if(CartList.contains(aItem)) {
			temp = CartList.indexOf(aItem);
			current = quantity.get(temp);
			current = current + 1;
			quantity.set(temp, current);
		}
		else {
			temp = 1;
			CartList.add(aItem);
			quantity.add(temp);
			quantity.set(quantity.size() -1, 1);
		}
	}
	
	//returns carList
	public ArrayList<InventoryItem> getCartList() {
		return(CartList);
	}
	
	//remove item by object or barcode
	public void removeItem (InventoryItem aItem ) {
		int temp;
		temp = CartList.indexOf(aItem);
		quantity.remove(temp);
		CartList.remove(aItem);
		
	}
	
	public void removeItem(int abarcode) {
		for(int i= 0; i < GroceryStore.InventoryList.size(); i++) {
			if(GroceryStore.InventoryList.get(i).getBarcode() == abarcode) {
				removeItem(GroceryStore.InventoryList.get(i));
			}
		}
	}
	
	//set discount
	public void setDiscount(double aDiscount) {
		discount = aDiscount;
	}
	
	//returns quanity in cart of an object given
	public int getQuantity(InventoryItem aItem) {
		int temp;
		temp = CartList.indexOf(aItem);
		temp = quantity.get(temp);
		return(temp);
	}
	
	//discount calculation at checkout
	public void applyDiscount () {
		if(discount != 0) {
		discount = checkoutCost * (discount * .01);
		checkoutCost = checkoutCost - discount;
		}
	}
		
	//finish checkout
	public void checkout () {
		for(int i = 0; i < CartList.size(); i++) {
			
			if(GroceryStore.InventoryList.contains(CartList.get(i))){
				GroceryStore.InventoryList.get(GroceryStore.InventoryList.indexOf(CartList.get(i))).decreaseStock(quantity.get(i));
				
				System.out.println(quantity.get(i) + " " + CartList.get(i).getName() + " was purchased at "
				+ CartList.get(i).getPrice() + "$ each." );
				
				checkoutCost = checkoutCost + (CartList.get(i).getPrice() * quantity.get(i));
			}
			else {
				System.out.println(CartList.get(i).getName() + " is not in stock to sell");
			}
			
			
		}
		applyDiscount();
		System.out.println("Total cost of sale = " + checkoutCost + "$. \n" );
		saleCompleted = true;
		
	}
}

