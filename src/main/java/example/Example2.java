package example;

import example.messages.PingPongMessage;
import framework.ActorApp;
import framework.supervisor.SuperVisor;

import java.util.UUID;

public class Example2 {
    public static void main(String[] args) {
        SuperVisor superVisor = ActorApp.run("example.actors").superVisor();

        UUID messageBouncer = superVisor.spawnActor("MessageBouncer");
        UUID messageBouncer2 = superVisor.spawnActor("MessageBouncer");

        superVisor.sendMessage(new PingPongMessage(5), messageBouncer, messageBouncer2);
    }
}
