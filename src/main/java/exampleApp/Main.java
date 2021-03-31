package exampleApp;

import exampleApp.actors.Greeting;
import exampleApp.actors.Spawn;
import framework.ActorApp;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ActorApp app = ActorApp.run("exampleApp.actors");
        UUID uuid = app.superVisor().spawnActor("Example");
        app.superVisor().sendMessage(uuid, new Greeting("Main"));
        app.superVisor().sendMessage(uuid, new Spawn("Example2"));
    }
}
