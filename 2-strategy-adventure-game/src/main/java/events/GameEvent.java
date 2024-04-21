package events;

import characters.GameCharacter;

public interface GameEvent {
    public String createEventMessage();
    public void perform();
}
