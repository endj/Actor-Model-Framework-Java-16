package framework.supervisor;

import framework.Actor;
import framework.Message;
import framework.registry.ActorRegistry;
import framework.spawn.ActorFactory;

import java.util.UUID;


public class SuperVisor {
    private final ActorFactory actorFactory;
    private final ActorRegistry actorRegistry;


    public SuperVisor(ActorFactory actorFactory, ActorRegistry actorRegistry) {
        this.actorFactory = actorFactory;
        this.actorRegistry = actorRegistry;
    }

    public UUID spawnActor(String actorName) {
        Actor actor = actorFactory.loadActor(actorName);
        return actorRegistry.registerActor(actor);
    }

    public void sendMessage(UUID uuid, Message message) {
        Actor actor = actorRegistry.getActor(uuid);
        actor.onMessage(message);
    }
}
