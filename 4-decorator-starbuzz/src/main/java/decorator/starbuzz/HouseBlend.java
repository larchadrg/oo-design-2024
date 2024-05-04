package decorator.starbuzz;

public class HouseBlend extends Beverage {
	public HouseBlend(BeverageSize size) {
		description = "House Blend Coffee";
		this.size = size;
	}
 
	public double cost() {
		return .89;
	}
}

