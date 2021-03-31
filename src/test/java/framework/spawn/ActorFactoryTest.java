package framework.spawn;

import framework.Actor;
import framework.test_actors.ActorWithArgs;
import framework.test_actors.CrashOnInitiationActor;
import framework.test_actors.TestActor;
import framework.spawn.exceptions.UnrecoverableException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorFactoryTest {

    private final static ActorFactory ACTOR_FACTORY = new ActorFactory("framework.test_actors");

    @Test
    void shouldSpawnActorGivenClassSimpleName() {
        TestActor testActor = ACTOR_FACTORY.loadActor(TestActor.class.getSimpleName());
        assertTrue(isActor(testActor));
    }

    @Test
    void shouldSpawnActorWithArguments() {
        ActorWithArgs actor = ACTOR_FACTORY.loadActor(ActorWithArgs.class.getSimpleName(), "Hello", 123);
        assertTrue(isActor(actor));
    }

    @Test
    void shouldFailWhenInvalidArgumentsProvided() {
        assertThrows(UnrecoverableException.class, () -> {
            ACTOR_FACTORY.loadActor(ActorWithArgs.class.getSimpleName(), "Wrong ARgs!!11");
        });
    }

    @Test
    void shouldThrowExceptionOnInitiationException() {
        assertThrows(UnrecoverableException.class, () -> {
            ACTOR_FACTORY.loadActor(CrashOnInitiationActor.class.getSimpleName());
        });
    }

    @Test()
    void shouldThrowExceptionOnNonActorClass() {
        assertThrows(UnrecoverableException.class, () -> {
            ACTOR_FACTORY.loadActor(null);
        });
    }

    private boolean isActor(Object target) {
        return target instanceof Actor;
    }
}