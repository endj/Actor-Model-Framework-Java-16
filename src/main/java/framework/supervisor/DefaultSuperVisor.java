package framework.supervisor;

import framework.registry.ActorRegistry;
import framework.spawn.ActorFactory;

public final class DefaultSuperVisor extends SuperVisor {

    private DefaultSuperVisor(String actorPackage) {
        super(new ActorFactory(actorPackage), new ActorRegistry());
    }

    public static SuperVisor actors(String actorPackage) {
        return new DefaultSuperVisor(actorPackage);
    }
}
