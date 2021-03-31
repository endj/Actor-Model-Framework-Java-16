package example.actors;

import example.messages.PingPongMessage;
import framework.Actor;
import framework.Message;

import java.util.UUID;

public class MessageBouncer extends Actor {
    @Override
    public void onMessage(Message message, UUID from) {
        if (message instanceof PingPongMessage pong) {
            if (pong.bounces() > 0) {
                pong.bounce();
                sendMessage(new PingPongMessage(pong.bounces() - 1), from);
            }
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - " + this.getId();
    }
}
