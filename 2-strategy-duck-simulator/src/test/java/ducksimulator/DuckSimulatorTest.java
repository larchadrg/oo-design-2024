package ducksimulator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import output.MockOutput;
import output.Output;
import simulator.Duck;
import simulator.MallardDuck;
import simulator.ModelDuck;

public class DuckSimulatorTest {

    @Test
    public void testMallardDuckFly(){
        Output mockOutput = new MockOutput();
        mockOutput.print("I'm flying!!");

        Duck mallard = new MallardDuck(mockOutput);
        mallard.performFly();
    }

    /*
    @Test
    public void testMallardDuckQuack() {
        MallardDuck mallard = new MallardDuck();
        mallard.performQuack();
        assertEquals("Quack",outContent.toString().trim());
    }

    @Test
    public void testModelDuckFly() {
        Duck duck = new ModelDuck();
        duck.performFly();
        assertEquals("I can't fly",outContent.toString().trim());
    }
    @Test
    public void testModelDuckQuack() {
        Duck duck = new ModelDuck();
        duck.performQuack();
        assertEquals("I can't quack",outContent.toString().trim());
    }
*/
    
}
