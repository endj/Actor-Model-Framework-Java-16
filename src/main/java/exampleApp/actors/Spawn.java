package exampleApp.actors;

import framework.Message;

public record Spawn(String actorName) implements Message {
}
