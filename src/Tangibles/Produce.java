package Tangibles;

public class Produce extends InventoryItem implements java.io.Serializable   {
	private boolean fruit;
	private boolean vegetable;
	
	public boolean isFruit() {
		return fruit;
	}
	public void setFruit(boolean fruit) {
		this.fruit = fruit;
	}
	public boolean isVegetable() {
		return vegetable;
	}
	public void setVegetable(boolean vegetable) {
		this.vegetable = vegetable;
	}
}
