package ua.mstt.plietnov.lb1.custom.behaviour;

import jade.core.behaviours.Behaviour;


/**
 * @author Vladyslav Plietnov
 */

public class OverbearingBehaviour extends Behaviour {
    @Override
    public void action() {
        while (true) {
            System.out.println("OverbearingBehaviour");
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
