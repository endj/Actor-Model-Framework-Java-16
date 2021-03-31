package example;

import example.messages.Greetings;
import framework.ActorApp;
import framework.supervisor.SuperVisor;

import java.util.UUID;

public class Example1 {
    public static void main(String[] args) {
        SuperVisor superVisor = ActorApp.run("example.actors").superVisor();

        UUID recipientId = superVisor.spawnActor("ReceivingActor");
        UUID forwarderId = superVisor.spawnActor("Forwarder");

        superVisor.sendMessage(new Greetings("hello", recipientId), forwarderId);
    }
}
