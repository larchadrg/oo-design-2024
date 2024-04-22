import game.Game;
import game.GameEventManager;
import org.junit.jupiter.api.Test;
import output.Logger;
import output.ScreenLogger;

public class TestGame {
    @Test
    public void testAddAndRemoveObservers(){
        GameEventManager manager = new GameEventManager();
        Logger logger = new ScreenLogger();
        manager.registerObserver(logger);
        manager.removeObserver(logger);
    }
    
}
