package weapons;

import output.Output;
import output.Terminal;

public class BareHands extends Weapon implements WeaponBehaviour{
    public BareHands(Output output){
        super(output);
    }

    @Override
    public void attack() {
        output.print("you punched");
    }

    @Override
    public void showWeapon() {
        output.print("Uses his bare hands");
    }
}
