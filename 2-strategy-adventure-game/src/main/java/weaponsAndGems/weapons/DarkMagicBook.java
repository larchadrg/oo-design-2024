package weaponsAndGems.weapons;

import characters.FightStyle;
import weaponsAndGems.Weapon;

public class DarkMagicBook extends ConcreteWeapon {
    @Override
    public String getName() {
        return "Dark Magic Book";
    }

    @Override
    public FightStyle getFightStyle() {
        return FightStyle.MAGIC;
    }

    @Override
    public int getDamage() {
        return 80;
    }

    @Override
    public int maximumNumberOfGemsAllowed() {
        return 1;
    }
}
