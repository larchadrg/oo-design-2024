import characters.GameCharacter;
import characters.Mage;
import events.ChangeWeaponEvent;
import events.ShowWeaponEvent;
import game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.Logger;
import output.Output;
import weapons.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class TestCharacterMockito {

    private Game game;
    private GameCharacter character;

    @Mock
    private Logger mockLogger;

    @BeforeEach
    public void setUp(){
        game = new Game(new Output[]{mockLogger});
        character = new Mage(1,1);
    }

    @Test
    public void testShowDefaultWeapon() {
        game.showWeapon(character);

        assertInstanceOf(BareHands.class, character.getWeapon());
        verify(mockLogger).update(ArgumentMatchers.any(ShowWeaponEvent.class));
    }

    @Test
    public void testCharacterChangeWeapon(){
        WeaponBehaviour book = new DarkMagicBook();
        game.changeWeapon(character, book);

        assertEquals(book, character.getWeapon());
        verify(mockLogger).update(ArgumentMatchers.any(ChangeWeaponEvent.class));
    }

    @Test
    public void testMageCantEquipSword(){
        assertThrows(IllegalArgumentException.class,
                ()->  game.changeWeapon(character, new Bow())
        );
    }

    @Test
    public void testShowMageClassName(){
        assertEquals("Mage", character.getName());
    }
}
