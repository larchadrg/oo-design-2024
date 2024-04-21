package characters;

import weapons.BareHands;
import weapons.WeaponBehaviour;

public abstract class GameCharacter{
    WeaponBehaviour weaponBehaviour;
    int baseLifePoints;
    int currentLifePoints;
    int speed;
    FightStyle fightStyle;
    String name;

    public GameCharacter(int baseLifePoints, int speed){
        this.baseLifePoints = baseLifePoints;
        this.currentLifePoints = baseLifePoints;
        this.speed = speed;
        this.weaponBehaviour = new BareHands();
    }

    public void setWeapon(WeaponBehaviour weapon){
        if (weapon.getFightStyle() != fightStyle) throw new IllegalArgumentException("The character cant use this weapon");
        weaponBehaviour = weapon;
    }

    public int getCurrentLifePoints(){
        return currentLifePoints;
    }

    public boolean isAlive(){
        return currentLifePoints > 0;
    }

    public int getSpeed(){
        return speed;
    }

    public boolean repOk(){
        if (currentLifePoints < 0) return false;
        if (speed < 0) return false;
        if (baseLifePoints < 0) return false;
        if (currentLifePoints > baseLifePoints) return false;
        return true;
    }

    public int getAttackDamage() {
        return weaponBehaviour.getDamage();
    }

    public void receiveDamage(int damage) {
        if (damage < 0) throw new IllegalArgumentException("negative damage");
        if (damage > currentLifePoints) currentLifePoints = 0;
        else currentLifePoints = currentLifePoints - damage;
    }

    public String getName(){
        return name;
    };

    public void attack(GameCharacter character){
        int damage = calculateEffectiveDamageAgainst(character);
        character.receiveDamage(damage);
    }

    public int calculateEffectiveDamageAgainst(GameCharacter character){
        int damage = weaponBehaviour.getDamage();
        if (damage >= character.currentLifePoints) return character.currentLifePoints;
        else return damage;
    }

    public WeaponBehaviour getWeapon(){
        return weaponBehaviour;
    }
}