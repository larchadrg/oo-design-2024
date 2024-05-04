import characters.GameCharacter;
import characters.Mage;
import game.Game;
import org.junit.jupiter.api.Test;
import output.FileLogger;
import output.Observer;
import output.Output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOutput {
    @Test
    public void testFileOutput(){
        String filename = "gameLog.txt";
        try {
            Game game = new Game(new Observer[]{new FileLogger(filename)});
            GameCharacter mage = new Mage(1, 1);
            game.showWeapon(mage);
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String message = br.readLine();
            assertEquals("Mage is now using Fist", message);
        } catch (IOException e){
            assert false;
        }
    }
}
