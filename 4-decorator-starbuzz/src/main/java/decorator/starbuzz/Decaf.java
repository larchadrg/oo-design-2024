package decorator.starbuzz;

public class Decaf extends Beverage {
	public Decaf(BeverageSize size) {
		description = "Decaf Coffee";
		this.size = size;
	}
 
	public double cost() {
		return 1.05;
	}
}

