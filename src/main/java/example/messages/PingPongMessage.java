package example.messages;

import framework.Message;

public record PingPongMessage(int bounces) implements Message {
    public void bounce() {
        System.out.println("Ping! " + bounces);
    }
}
