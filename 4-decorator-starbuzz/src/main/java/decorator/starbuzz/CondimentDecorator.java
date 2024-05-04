package decorator.starbuzz;

import java.util.Map;

public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	Map<BeverageSize,Double> costBySize;

	public CondimentDecorator(Beverage beverage){
		this.beverage = beverage;
		this.size = beverage.getSize();
	}

	public abstract String getDescription();

	@Override
	public double cost(){
		return costBySize.get(size) + beverage.cost();
	}
}
