package weaponsAndGems;

import characters.FightStyle;

public interface Weapon {
    public String getName();
    public FightStyle getFightStyle();

    int getDamage();
    int maximumNumberOfGemsAllowed();
    int amountGemsInWeapon();
}
