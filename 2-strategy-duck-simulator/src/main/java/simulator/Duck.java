package simulator;

import output.Output;
import output.Terminal;

public abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	Output output;

	public Duck(Output output) {
		this.output = output;
	}

	public Duck(){
		output = new Terminal();
	}


	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

	abstract void display();

	public void performFly() {
		flyBehavior.fly(output);
	}

	public void performQuack() {
		quackBehavior.quack(output);
	}

	public void swim() {
		output.print("All ducks float, even decoys!");
	}
}
