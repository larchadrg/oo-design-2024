package decorator.starbuzz;

public class DarkRoast extends Beverage {
	public DarkRoast(BeverageSize size) {
		description = "Dark Roast Coffee";
		this.size = size;
	}
 
	public double cost() {
		return .99;
	}

}

