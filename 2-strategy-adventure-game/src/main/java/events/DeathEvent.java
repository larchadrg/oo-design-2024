package events;

import characters.GameCharacter;

public class DeathEvent implements GameEvent{
    GameCharacter c;
    public DeathEvent(GameCharacter c){
        this.c = c;
    }

    @Override
    public String createEventMessage() {
        return c.getName() + " died.";
    }

    @Override
    public void perform() {
    }
}
