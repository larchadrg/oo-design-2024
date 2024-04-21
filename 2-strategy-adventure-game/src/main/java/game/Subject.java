package game;
import events.GameEvent;
import output.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(GameEvent eventType);
}
