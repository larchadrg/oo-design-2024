package simulator;

import output.Output;

public class FlyWithWings implements FlyBehavior {
	public void fly(Output out) {
		out.print("I'm flying!!");
	}
}
