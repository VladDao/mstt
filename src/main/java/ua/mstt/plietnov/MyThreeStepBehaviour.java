package ua.mstt.plietnov;

import jade.core.behaviours.Behaviour;

/**
 * @author Vladyslav Plietnov
 */

public class MyThreeStepBehaviour extends Behaviour {

    private int step = 0;

    @Override
    public void action() {
        switch (step) {
            case 0:
                doSomething();
                break;
            case 1:
                doSomething();
                break;
            case 2:
                doSomething();
                break;
        }
    }

    private void doSomething() {
        step++;
        logStep();
    }

    @Override
    public boolean done() {
        return false;
    }

    private void logStep() {
        System.out.println("Step №" + step);
    }
}
