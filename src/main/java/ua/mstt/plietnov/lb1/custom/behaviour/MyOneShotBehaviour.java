package ua.mstt.plietnov.lb1.custom.behaviour;

import jade.core.behaviours.OneShotBehaviour;

/**
 * @author Vladyslav Plietnov
 */

public class MyOneShotBehaviour extends OneShotBehaviour {
    @Override
    public void action() {
        System.out.println("OneShotBehaviour");
    }
}
