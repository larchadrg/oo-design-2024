package weapons;

import output.Output;

public class AttackWithBow implements WeaponBehaviour {
    Output output;
    @Override
    public void attack() {
        output.print("attacked with bow")
    }

    @Override
    public void showWeapon() {

    }
}
