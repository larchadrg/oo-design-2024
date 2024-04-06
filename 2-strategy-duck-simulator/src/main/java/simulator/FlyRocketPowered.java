package simulator;

import output.Output;

public class FlyRocketPowered implements FlyBehavior {
	public void fly(Output output) {
		output.print("I'm flying with a rocket");
	}
}
