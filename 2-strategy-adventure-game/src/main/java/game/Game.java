package game;

import characters.GameCharacter;
import output.*;
import weaponsAndGems.Weapon;

public class Game {
    public GameEventManager eventManager;

    public Game(){
        Observer[] observers = {new ScreenLogger(), new FileLogger("gameLog.txt"), new GameStatsManager()};
        eventManager = new GameEventManager(observers);
    }

    public Game(Observer[] observers){
        eventManager = new GameEventManager(observers);
    }

    public void changeWeapon(GameCharacter c, Weapon weapon){
        c.setWeapon(weapon);
        eventManager.notifyObserversWeapon(c);
    }

    public void performBattle(GameCharacter c1, GameCharacter c2) {
        GameCharacter attacker = getFirstAttacker(c1, c2);
        GameCharacter receiver = getSecondAttacker(c1, c2);

        while (attacker.isAlive() && receiver.isAlive()) {
            int damage = attacker.attack(receiver);
            eventManager.notifyObserversAttack(damage, attacker, receiver);
            GameCharacter temp = attacker;
            attacker = receiver;
            receiver = temp;
        }
        if (!c1.isAlive()) eventManager.notifyObserversKill(c2,c1);
        else eventManager.notifyObserversKill(c1,c2);
    }

    public void showWeapon(GameCharacter character) {
        eventManager.notifyObserversWeapon(character);
    }

    private GameCharacter getFirstAttacker(GameCharacter character1, GameCharacter character2){
        return character1.getSpeed() >= character2.getSpeed() ? character1 : character2;
    }
    private GameCharacter getSecondAttacker(GameCharacter character1, GameCharacter character2){
        return getFirstAttacker(character1, character2) == character1 ? character2 : character1;
    }
}
