package Software;

import java.util.ArrayList;
import java.util.HashMap;

import org.library.MyClasses.InventoryItem;

public class InPersonCheckout {
	private double discount;
	private HashMap<Integer , Tangibles.InventoryItem> ItemsInCart = new HashMap<Integer, Tangibles.InventoryItem>();
	private ArrayList<Tangibles.InventoryItem> Items = new ArrayList<Tangibles.InventoryItem>();
	
	public void addItem(Tangibles.InventoryItem ItemsB)
	{
		Items.add(ItemsB);
	}
	
	public void addItemToCart (int abarcode) {
		for(Tangibles.InventoryItem Item : Items){
			if(Item.getBarcode() == abarcode){
				ItemsInCart.put(abarcode, Item);
			}
		}
		
		
	}
	
	public void removeItem (int abarcode ) {
	for (Tangibles.InventoryItem Item : Items) {
		if (Item.getBarcode() == abarcode) {
			ItemsInCart.remove(abarcode);
		}
	  }
	}
	
	public void applyDiscount (double discount, double price) {
		this.discount = price / (this.discount * .01);
		price = price - this.discount;
	}
	
	public void checkout () {
		for(Tangibles.InventoryItem item : Items) {
			ItemsInCart.remove(item.getBarcode());
		}
	}
}

