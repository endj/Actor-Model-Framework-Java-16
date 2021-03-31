package example;

import example.messages.DoWork;
import framework.ActorApp;
import framework.supervisor.SuperVisor;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Spawning many simple Actors that just receive a task, performs it and remembers how many tasks it has
 * done.
 * <p>
 * At the moment actors are persisted and can't do a task when created, but the general idea is to be able
 * to spawn many wagies to perform work with a initial message.
 * <p>
 * Millions of issues to solve with full mailboxes, priority, locking etc
 */
public class Example4 {
    public static void main(String[] args) {
        SuperVisor superVisor = ActorApp.run("example.actors").superVisor();
        List<UUID> wageSlaves = IntStream.range(0, 1_000_000)
                .mapToObj(__ -> superVisor.spawnActor("Wagie"))
                .collect(Collectors.toList());

        int boxesToLiftAndPackagesToMove = 1_000_000;
        while (boxesToLiftAndPackagesToMove != 0) {
            UUID uuid = pickRandomWorker(wageSlaves);
            while (!superVisor.sendMessage(new DoWork(boxesToLiftAndPackagesToMove), uuid)) ;
            boxesToLiftAndPackagesToMove--;
        }
        System.out.println("All Done!");
    }

    private static UUID pickRandomWorker(List<UUID> uuids) {
        int i = ThreadLocalRandom.current().nextInt(uuids.size());
        return uuids.get(i);
    }
}
