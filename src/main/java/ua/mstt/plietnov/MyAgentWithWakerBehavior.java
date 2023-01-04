package ua.mstt.plietnov;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

/**
 * @author Vladyslav Plietnov
 */

public class MyAgentWithWakerBehavior extends Agent {
    protected void setup() {
        System.out.println("Adding waker behaviour");
        addBehaviour(new WakerBehaviour(this, 10000) {
            protected void handleElapsedTimeout() {
                System.out.println("Hello I am from wake behavior! -> handleElapsedTimeout");
            }
        });
    }
}

