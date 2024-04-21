import characters.GameCharacter;
import characters.Mage;
import game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weapons.DarkMagicBook;

public class GameTest {
    Game game;

    @BeforeEach
    public void createGame(){
        game = new Game();
    }

    @Test
    public void testNewGameCreatedSuccessfully(){
        return;
    }

    @Test
    public void testChangeWeaponEvent(){
        GameCharacter mage = new Mage(2,2);
        game.changeWeapon(mage, new DarkMagicBook());
    }
}
