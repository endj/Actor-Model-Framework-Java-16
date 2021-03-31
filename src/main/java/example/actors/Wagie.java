package example.actors;

import example.messages.DoWork;
import framework.Actor;
import framework.Message;

import java.util.UUID;

public class Wagie extends Actor {
    int tasksDone = 0;

    @Override
    public void onMessage(Message message, UUID senderId) {
        if (message instanceof DoWork work) {
            System.out.println("Worker: " + this.getId() + " performing work " + work.id() + " tasksDone " + tasksDone++);
            //  work.restSome();
        }
    }
}
