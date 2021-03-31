package framework.test_actors;

import framework.Actor;

public class CrashOnInitiationActor implements Actor {
    public CrashOnInitiationActor() {
        throw new RuntimeException();
    }
}
