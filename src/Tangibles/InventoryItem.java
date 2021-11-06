package Tangibles;

public class InventoryItem {
	
	private String name;
	private int stock; //number in stock
	private int aisle; //aisle its located in
	private long barcode;
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public InventoryItem() {
		GroceryStore.InventoryList.add(this);
	}
	
	public void increaseStock(int amount) {
		stock = stock + amount;
	}
	
	public void decreaseStock(int amount) {
		stock = stock - amount;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getAisle() {
		return aisle;
	}

	public void setAisle(int aisle) {
		this.aisle = aisle;
	}

	public long getBarcode() {
		return barcode;
	}

	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
