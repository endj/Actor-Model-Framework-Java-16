package exampleApp.actors;

import framework.Message;

public record Greeting(String from) implements Message {

    public void greet() {
        System.out.println("hello from" + from);
    }
}
