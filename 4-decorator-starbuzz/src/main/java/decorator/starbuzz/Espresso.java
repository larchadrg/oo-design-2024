package decorator.starbuzz;

public class Espresso extends Beverage {
  
	public Espresso(BeverageSize size) {
		description = "Espresso";
		this.size = size;
	}
  
	public double cost() {
		return 1.99;
	}
}

