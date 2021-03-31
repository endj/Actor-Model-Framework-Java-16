package framework.test_actors;

import framework.Actor;

public class CrashOnInitiationActor extends Actor {
    public CrashOnInitiationActor() {
        throw new RuntimeException();
    }
}
