package example;

import example.messages.PingPongMessage;
import framework.ActorApp;
import framework.supervisor.SuperVisor;

import java.util.UUID;

/**
 * Here the actor will ping itself until the message is received with 0
 */
public class Example3 {
    public static void main(String[] args) {
        SuperVisor superVisor = ActorApp.run("example.actors").superVisor();

        UUID id = superVisor.spawnActor("MessageBouncer");

        superVisor.sendMessage(new PingPongMessage(5), id, id);
    }
}
