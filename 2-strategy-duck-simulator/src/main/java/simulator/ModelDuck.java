package simulator;

public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new QuackNoWay();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}
