package weaponsAndGems.weapons;

import weaponsAndGems.Weapon;

public abstract class ConcreteWeapon implements Weapon {
    @Override
    public int amountGemsInWeapon() {
        return 0;
    }
}
