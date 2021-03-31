package framework;

import java.util.UUID;

public interface Actor {

    default UUID spawnActor(String name) {
        return ActorApp._getSuperVisor().spawnActor(name);
    }

    default void sendMessage(UUID id, Message message) {
        ActorApp._getSuperVisor().sendMessage(id, message);
    }

    default void onMessage(Message message) {}
}
