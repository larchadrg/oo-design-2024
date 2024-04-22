import characters.Archer;
import characters.GameCharacter;
import characters.Mage;
import game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weapons.Bow;
import weapons.DarkMagicBook;

import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {
    Game game;
    GameCharacter mage;
    GameCharacter archer;

    @BeforeEach
    public void setUp(){
        game = new Game();
        archer = new Archer(100,30);
        game.changeWeapon(archer, new Bow()); //50 damage
        mage = new Mage(100,20);
        game.changeWeapon(mage, new DarkMagicBook()); // 80 damage
    }

    @Test
    public void testBattle(){
        game.performBattle(archer, mage);
        assertTrue(archer.isAlive());
        assertFalse(mage.isAlive());
        assertEquals(20, archer.getCurrentLifePoints());
    }
}
