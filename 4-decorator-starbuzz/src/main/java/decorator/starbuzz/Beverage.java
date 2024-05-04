package decorator.starbuzz;

public abstract class Beverage {
	String description;
	BeverageSize size;

	public String getDescription() {
		return description;
	}
 
	public abstract double cost();

	public BeverageSize getSize(){
		return size;
	}
}
