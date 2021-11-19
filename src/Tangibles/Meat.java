package Tangibles;

public class Meat extends InventoryItem implements java.io.Serializable  {
	private boolean chicken;
	private boolean pork;
	private boolean beef;
	private boolean fish;
	
	public boolean isChicken() {
		return chicken;
	}
	public void setChicken(boolean chicken) {
		this.chicken = chicken;
	}
	public boolean isPork() {
		return pork;
	}
	public void setPork(boolean pork) {
		this.pork = pork;
	}
	public boolean isBeef() {
		return beef;
	}
	public void setBeef(boolean beef) {
		this.beef = beef;
	}
	public boolean isFish() {
		return fish;
	}
	public void setFish(boolean fish) {
		this.fish = fish;
	}
	
}
