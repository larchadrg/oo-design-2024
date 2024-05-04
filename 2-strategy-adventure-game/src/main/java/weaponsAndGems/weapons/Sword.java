package weaponsAndGems.weapons;

import characters.FightStyle;
import weaponsAndGems.Weapon;

public class Sword extends ConcreteWeapon {

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public FightStyle getFightStyle() {
        return FightStyle.MELEE;
    }

    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public int maximumNumberOfGemsAllowed() {
        return 2;
    }
}
