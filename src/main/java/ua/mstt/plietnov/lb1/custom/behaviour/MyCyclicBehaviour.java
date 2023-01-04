package ua.mstt.plietnov.lb1.custom.behaviour;

import jade.core.behaviours.CyclicBehaviour;

/**
 * @author Vladyslav Plietnov
 */

public class MyCyclicBehaviour extends CyclicBehaviour {
    @Override
    public void action() {
        System.out.println("CyclicBehaviour");
    }
}
