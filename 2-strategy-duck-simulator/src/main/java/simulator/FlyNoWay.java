package simulator;

import output.Output;

public class FlyNoWay implements FlyBehavior {
	public void fly(Output output) {
		output.print("I can't fly");
	}
}
