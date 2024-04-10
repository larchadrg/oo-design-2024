package characters;

import output.Output;
import weapons.BareHands;
import weapons.WeaponBehaviour;

public abstract class GameCharacter {
    WeaponBehaviour weaponBehaviour;
    int baseLifePoints;
    int currentLifePoints;

    public GameCharacter(Output output, int baseLifePoints){
        weaponBehaviour = new BareHands(output);
        this.baseLifePoints = baseLifePoints;
        this.currentLifePoints = baseLifePoints;
    }

    public void showWeapon(){
        weaponBehaviour.showWeapon();
    }

    public void changeWeapon(WeaponBehaviour weapon){
        weaponBehaviour = weapon;
    }
}