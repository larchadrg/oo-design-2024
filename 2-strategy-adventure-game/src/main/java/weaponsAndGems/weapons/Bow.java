package weaponsAndGems.weapons;

import characters.FightStyle;
import weaponsAndGems.Weapon;

public class Bow extends ConcreteWeapon {
    @Override
    public String getName(){
        return "Bow";
    }

    @Override
    public FightStyle getFightStyle() {
        return FightStyle.RANGED;
    }

    @Override
    public int getDamage() {
        return 50;
    }

    @Override
    public int maximumNumberOfGemsAllowed() {
        return 1;
    }
}
