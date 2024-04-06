package simulator;

import output.Output;

public class MallardDuck extends Duck {
	Output output;

	public MallardDuck(Output output) {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
		this.output = output;
	}

	public void display() {
		output.print("I'm a real Mallard duck");
	}

}
