package exampleApp.actors;

import framework.Actor;
import framework.Message;

import java.util.UUID;

public class Example implements Actor {

    @Override
    public void onMessage(Message message) {
        if(message instanceof Greeting g) {
            g.greet();
        }
        if(message instanceof Spawn s) {
            UUID uuid = spawnActor(s.actorName());
            sendMessage(uuid, new Greeting("Hi from"));
        }
    }
}
