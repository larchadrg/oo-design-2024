package characters;

import weaponsAndGems.weapons.BareHands;
import weaponsAndGems.Weapon;

public abstract class GameCharacter{
    public Weapon weapon;
    int baseLifePoints;
    int currentLifePoints;
    int speed;
    FightStyle fightStyle;
    public String name;


    public GameCharacter(int baseLifePoints, int speed){
        this.baseLifePoints = baseLifePoints;
        this.currentLifePoints = baseLifePoints;
        this.speed = speed;
        this.weapon = new BareHands();
    }

    public void setWeapon(Weapon weapon){
        if (weapon.getFightStyle() != fightStyle) throw new IllegalArgumentException("The character cant use this weapon");
        this.weapon = weapon;
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
        return currentLifePoints <= baseLifePoints;
    }
    
    private void receiveDamage(int damage) {
        if (damage < 0) throw new IllegalArgumentException("negative damage");
        if (damage > currentLifePoints) currentLifePoints = 0;
        else currentLifePoints = currentLifePoints - damage;
    }

    public String getName(){
        return name;
    }

    public int attack(GameCharacter character){
        if(!character.isAlive()) throw new IllegalStateException(character.name + " is dead.");
        int damage = calculateEffectiveDamageAgainst(character);
        character.receiveDamage(damage);
        return damage;
    }

    private int calculateEffectiveDamageAgainst(GameCharacter character){
        int damage = weapon.getDamage();
        return Math.min(damage, character.currentLifePoints);
    }

    public Weapon getWeapon(){
        return weapon;
    }

}