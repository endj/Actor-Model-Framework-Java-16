package framework.registry;

import framework.Actor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ActorRegistry {
    private static final Map<UUID, Actor> map = new HashMap<>();

    public UUID registerActor(Actor actor) {
        map.put(actor.getId(), actor);
        return actor.getId();
    }

    public Actor getActor(UUID uuid) {
        return map.get(uuid);
    }
}
