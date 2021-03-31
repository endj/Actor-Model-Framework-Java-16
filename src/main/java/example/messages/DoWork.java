package example.messages;

import framework.Message;

public record DoWork(int id) implements Message {
    void restSome() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Back to work");
        }
    }
}
