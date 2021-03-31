package exampleApp.actors;

import framework.Actor;
import framework.Message;

public class Example2 implements Actor {
    @Override
    public void onMessage(Message message) {
        System.out.println("Got message from Example");
    }
}
