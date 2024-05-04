import characters.GameCharacter;
import characters.Mage;
import game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.Logger;
import output.Observer;
import weaponsAndGems.Weapon;
import weaponsAndGems.weapons.BareHands;
import weaponsAndGems.weapons.Bow;
import weaponsAndGems.weapons.DarkMagicBook;

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
        game = new Game(new Observer[]{mockLogger});
        character = new Mage(1,1);
    }

    @Test
    public void testShowDefaultWeapon() {
        assertInstanceOf(BareHands.class, character.getWeapon());
    }

    @Test
    public void testCharacterChangeWeapon(){
        Weapon book = new DarkMagicBook();
        game.changeWeapon(character, book);
        assertEquals(book, character.getWeapon());
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

    @Test
    public void testCharacterRepOk(){
        assertTrue(character.repOk());
    }
}
