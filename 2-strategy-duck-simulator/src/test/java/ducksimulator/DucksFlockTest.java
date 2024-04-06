package ducksimulator;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.Output;
import simulator.Duck;
import simulator.DucksFlock;
import simulator.MallardDuck;
import simulator.ModelDuck;

import java.util.List;

public class DucksFlockTest {
    @BeforeEach
    public void setUpFullFlock(){
        Output output = EasyMock.mock(Output.class);
        Duck[] ducks = {new MallardDuck(mockOutput), new ModelDuck()};
        DucksFlock filledFlock = new DucksFlock(List.of(ducks), output);
    }

    @Test
    public void testEmptyFlockQuack(){

    }
}
