package example;

import example.messages.simd.DotProduct;
import example.messages.simd.DotProductFailure;
import example.messages.simd.DotProductResult;
import framework.Actor;
import framework.ActorApp;
import framework.Message;
import framework.registry.ActorRegistry;
import framework.supervisor.SuperVisor;

import java.util.Random;
import java.util.UUID;

public class Example5 {
    public static void main(String[] args) {
        var superVisor = ActorApp.run("example.actors").superVisor();
        UUID simdTest = superVisor.spawnActor("SIMDTest");

        Actor actor = new Actor() {
            @Override
            public void onMessage(Message message, UUID senderId) {
                if (message instanceof DotProductResult result) {
                    System.out.println(result);
                } else if (message instanceof DotProductFailure failure) {
                    System.err.println(failure.reason());
                }
                System.exit(0);
            }
        };
        registerAnonymousActorHack(superVisor, actor);
        actor.sendMessage(
                new DotProduct(
                        new Random().ints(1_000_000, 0, 100).toArray(),
                        new Random().ints(1_000_000, 0, 100).toArray()
                ),
                simdTest
        );
    }

    private static void registerAnonymousActorHack(SuperVisor superVisor, Actor actor) {
        try {
            var declaredField = superVisor.getClass().getSuperclass().getDeclaredFields()[1];
            declaredField.setAccessible(true);
            var o = (ActorRegistry) declaredField.get(superVisor);
            o.registerActor(actor);
        } catch (Exception e) {
            System.exit(1);
            throw new RuntimeException("yeah yeah whatever", e);
        }
    }
}
