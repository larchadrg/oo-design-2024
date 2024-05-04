package weaponsAndGems.weapons;

import characters.FightStyle;
import weaponsAndGems.Weapon;

public class BareHands extends ConcreteWeapon{

    @Override
    public String getName() {
        return "Fist";
    }

    @Override
    public FightStyle getFightStyle() {
        return FightStyle.MELEE;
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public int maximumNumberOfGemsAllowed() {
        return 0;
    }
}
