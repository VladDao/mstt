package ua.mstt.plietnov;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 * @author Vladyslav Plietnov
 */

public class MyAgentWithTickerBehaviour extends Agent {
    protected void setup() {
        System.out.println("Adding waker behaviour");
        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {
                System.out.println("Hello I am from ticker behavior! -> onTick");

            }
        });
    }
}

