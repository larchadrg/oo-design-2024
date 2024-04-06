package simulator;

import output.Output;

public class Quack implements QuackBehavior {
	public void quack(Output output) {
		output.print("Quack");
	}
}
