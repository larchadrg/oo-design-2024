package simulator;

import output.Output;

public class QuackNoWay implements QuackBehavior{
    @Override
    public void quack(Output output) {
        output.print("I can't quack");
    }
}
