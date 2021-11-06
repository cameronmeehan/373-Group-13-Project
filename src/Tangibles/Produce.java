package Tangibles;

public class Produce extends InventoryItem  {
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
