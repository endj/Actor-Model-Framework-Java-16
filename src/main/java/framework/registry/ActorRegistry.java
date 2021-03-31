package framework.registry;

import framework.Actor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ActorRegistry {
    private static final Map<UUID, Actor> map = new HashMap<>();

    public UUID registerActor(Actor actor) {
        UUID uuid = UUID.randomUUID();
        map.put(uuid, actor);
        return uuid;
    }

    public Actor getActor(UUID uuid) {
        return map.get(uuid);
    }
}
