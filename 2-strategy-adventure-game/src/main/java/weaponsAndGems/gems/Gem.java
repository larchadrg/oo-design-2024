package weaponsAndGems.gems;

import characters.FightStyle;
import weaponsAndGems.Weapon;

public abstract class Gem implements Weapon {
    Weapon weapon;
    int gemDamage;

    public Gem(Weapon weapon) {
        if (weapon == null) throw new IllegalArgumentException("Gem must be put into a weapon");
        this.weapon = weapon;
        if (amountGemsInWeapon() > maximumNumberOfGemsAllowed()) throw new IllegalArgumentException("Weapon cant have more than " + maximumNumberOfGemsAllowed() + " gems.");
    }

    @Override
    public int getDamage(){
        return gemDamage + weapon.getDamage();
    }

    @Override
    public FightStyle getFightStyle() {
        return weapon.getFightStyle();
    }

    @Override
    public int maximumNumberOfGemsAllowed() {
        return weapon.maximumNumberOfGemsAllowed();
    }

    @Override
    public int amountGemsInWeapon() {
        return 1 + weapon.amountGemsInWeapon();
    }
}
