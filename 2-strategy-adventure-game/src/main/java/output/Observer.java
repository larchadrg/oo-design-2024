package output;

import events.GameEvent;

public interface Observer {
    public void update(GameEvent event);
}
