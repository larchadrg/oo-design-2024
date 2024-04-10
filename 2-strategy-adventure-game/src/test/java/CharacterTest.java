import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import output.Output;
import characters.*;
import weapons.Bow;

public class CharacterTest {
    @Test
    public void testCharacterDefaultWeapon(){
        Output output = EasyMock.createMock(Output.class);
        output.print("Uses his bare hands");
        EasyMock.replay(output);

        GameCharacter mage = new Mage(output);
        mage.showWeapon();
        EasyMock.verify(output);
    }

    @Test
    public void testCharacterChangeWeapon(){
        Output output = EasyMock.createMock(Output.class);
        output.print("Uses his bare hands");
        output.print("holding a bow");
        EasyMock.replay();

        GameCharacter mage = new Mage(output);
        mage.showWeapon();
        mage.changeWeapon(new Bow(output));
        mage.showWeapon();
    }
}
