package framework.test_actors;

import framework.Actor;

public class ActorWithArgs implements Actor {
    String abc;
    int number;

    public ActorWithArgs(String abc, int number) {
        this.abc = abc;
        this.number = number;
    }
}
