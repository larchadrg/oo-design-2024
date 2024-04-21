import events.GameEvent;
import events.ShowWeaponEvent;
import game.Game;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import characters.*;
import output.Logger;
import output.Output;
import output.ScreenLogger;
import weapons.DarkMagicBook;
import weapons.Sword;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterTest {
    private GameCharacter mage;
    private Game game;
    private Logger screenLogger;

    @BeforeEach
    public void setUp(){
        screenLogger = mock(ScreenLogger.class);
        game = new Game(new Output[]{screenLogger});
        mage = new Mage(1,1);
    }

    @Test
    public void testCharacterDefaultWeapon(){
        Capture<GameEvent> capturedEvent = Capture.newInstance();
        screenLogger.update(capture(capturedEvent)); // Capture the event

        Capture<String> capturedMessage = Capture.newInstance();
        screenLogger.print(capture(capturedMessage));
        replay(screenLogger);

        game.showWeapon(mage);

        verify(screenLogger);
        GameEvent event = capturedEvent.getValue();
        Assertions.assertInstanceOf(ShowWeaponEvent.class, event);
        String message = capturedMessage.getValue();
        Assertions.assertEquals("Mage using bare hands", message);
    }

    /*
    @Test
    public void testCharacterChangeWeapon(){
        Capture<GameEvent> capturedShowEvent = Capture.newInstance();
        screenLogger.update(capture(capturedShowEvent)); // Capture the event


        Capture<String> capturedString = Capture.newInstance();
        screenLogger.print(capture(capturedString));
        capturedEvent = Capture.newInstance();
        screenLogger.update(capture(capturedEvent));
        screenLogger.print("holding a bow");
        EasyMock.replay(screenLogger);
        game.showWeapon(mage);
        game.changeWeapon(mage, new DarkMagicBook());
        EasyMock.verify(screenLogger);
    }
    */

    @Test
    public void testMageCantEquipSword(){
        assertThrows(IllegalArgumentException.class,
                ()->  mage.setWeapon(new Sword())
        );
    }

    @Test
    public void testShowMageClassName(){
        Assertions.assertEquals("Mage", mage.getName());
    }
}
