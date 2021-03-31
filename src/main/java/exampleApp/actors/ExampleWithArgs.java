package exampleApp.actors;

import framework.Actor;

public class ExampleWithArgs implements Actor {
    String abc;
    int aaa;

    public ExampleWithArgs(String abc) {
        this.abc = abc;
    }

    public ExampleWithArgs(String abc, int aaa) {
        this.abc = abc;
        this.aaa = aaa;
    }

    public void test() {
        System.out.println("afsas");
    }
}
