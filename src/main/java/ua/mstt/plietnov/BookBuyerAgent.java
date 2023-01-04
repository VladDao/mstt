package ua.mstt.plietnov;


import jade.core.Agent;

/**
 *  @author Vladyslav Plietnov
 */

public class BookBuyerAgent extends Agent {
    protected void setup() {
        // Printout a welcome message
        System.out.println("Hello !Buyer - agent " + getAID().getName() + "is ready.");
    }
}