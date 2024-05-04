package game;

import characters.GameCharacter;
import output.Observer;

import java.util.*;

public class GameEventManager implements Subject {
    ArrayList<Observer> observers;

    public GameEventManager(){
        observers = new ArrayList<>();
    }

    public GameEventManager(Observer[] observers){
        this.observers = new ArrayList<>();
        this.observers.addAll(Arrays.asList(observers));
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }


    public void notifyObserversAttack(int damage, GameCharacter attacker, GameCharacter receiver){
        for(Observer observer: observers){
            observer.updateAttack(damage, attacker, receiver);
        }
    }

    @Override
    public void notifyObserversKill(GameCharacter killer, GameCharacter victim) {
        for(Observer observer: observers){
            observer.updateKill(killer, victim);
        }
    }

    @Override
    public void notifyObserversWeapon(GameCharacter character) {
        for(Observer observer: observers){
            observer.updateWeapon(character);
        }
    }
}