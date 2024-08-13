package barista;

public class BlackCoffee extends CaffeineBeverage {
	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	/* no required anymore 	
	public void addCondiments() {
	}
	*/ 

	@Override
	public boolean requiresCondiments(){
		return false; 
	}
}
