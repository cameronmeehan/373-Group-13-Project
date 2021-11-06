package Tangibles;

public class Dairy extends InventoryItem {
	private boolean milk;
	private boolean cheese;
	private boolean yogurt;
	
	public boolean isMilk() {
		return milk;
	}
	public void setMilk(boolean milk) {
		this.milk = milk;
	}
	public boolean isCheese() {
		return cheese;
	}
	public void setCheese(boolean cheese) {
		this.cheese = cheese;
	}
	public boolean isYogurt() {
		return yogurt;
	}
	public void setYogurt(boolean yogurt) {
		this.yogurt = yogurt;
	}
}
