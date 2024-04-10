package weapons;

import output.Output;

public class Bow extends Weapon implements WeaponBehaviour {

    public Bow(Output output) {
        super(output);
    }

    @Override
    public void attack() {
        output.print("attacked with bow");
    }

    @Override
    public void showWeapon() {
        output.print("holding a bow");
    }
}
