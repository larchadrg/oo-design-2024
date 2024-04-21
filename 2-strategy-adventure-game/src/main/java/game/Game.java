package game;

import characters.GameCharacter;
import events.*;
import output.Output;
import output.ScreenLogger;
import output.Observer;
import weapons.WeaponBehaviour;

public class Game {
    public GameEventManager eventManager;

    public Game(){
        eventManager = new GameEventManager();
        eventManager.registerObserver(new ScreenLogger());
    }

    public Game(Output[] observers){
        eventManager = new GameEventManager();
        for(Output o : observers) eventManager.registerObserver((Observer) o);
    }

    public void changeWeapon(GameCharacter c, WeaponBehaviour weapon){
        GameEvent event = new ChangeWeaponEvent(c, weapon);
        event.perform();
        eventManager.notifyObservers(event);
    }

    public void performBattle(GameCharacter c1, GameCharacter c2){
        Battle battle = new Battle(c1, c2);
        GameCharacter firstAttacker = battle.getFirstAttacker(c1, c2);
        GameCharacter secondAttacker = battle.getSecondAttacker(c1,c2);

        while(battle.bothAlive(firstAttacker, secondAttacker)){
            GameEvent firstAttackerAttackEvent = new AttackEventGame(firstAttacker, secondAttacker);
            eventManager.notifyObservers(firstAttackerAttackEvent);
            if(!battle.bothAlive(c1,c2)) break;
            GameEvent secondAttackerAttackEvent = new AttackEventGame(secondAttacker, firstAttacker);
            eventManager.notifyObservers(secondAttackerAttackEvent);
        }
        notifyDeath(c1, c2);
    }

    private void notifyDeath(GameCharacter c1, GameCharacter c2){
        if(!c1.isAlive()){
            GameEvent event = new DeathEvent(c1);
            eventManager.notifyObservers(event);
        } else {
            GameEvent event = new DeathEvent(c2);
            eventManager.notifyObservers(event);
        }
    }

    public void showWeapon(GameCharacter character) {
        GameEvent event = new ShowWeaponEvent(character);
        eventManager.notifyObservers(event);
    }
}
