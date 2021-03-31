package framework;

import framework.test_actors.TestActor;
import framework.supervisor.DefaultSuperVisor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    @BeforeAll
    static void initSuperVisor() {
        ActorApp._setSuperVisor(DefaultSuperVisor.actors("framework.test_actors"));
    }

    @Test
    void actorsShouldBeAbleToCreateActors() {
        TestActor testActor = new TestActor();
        UUID uuid = testActor.spawnActor("TestActor");

        assertNotNull(uuid);
        assertTrue(isActor(testActor));
    }

    private boolean isActor(Object target) {
        return target instanceof Actor;
    }


}