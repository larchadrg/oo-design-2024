package game;

import events.GameEvent;
import output.Observer;

import java.util.*;

public class GameEventManager implements Subject {
    ArrayList<Observer> observers;

    public GameEventManager(){
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(GameEvent event) {
        for(Observer observer: observers){
            observer.update(event);
        }
    }
}