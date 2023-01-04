package ua.mstt.plietnov;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

/**
 * @author Vladyslav Plietnov
 */

public class BookSellerAgent extends Agent {
    private Map<String, Integer> catalogue;

    private BookSellerGui myGui;

    @Override
    protected void setup() {
        this.catalogue = new HashMap<>();
        myGui = new BookSellerGui(this);
        myGui.showGui();

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("book-selling");
        sd.setName("JADE-book-trading");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        addBehaviour(new OfferRequestsServer());
        addBehaviour(new PurchaseOrdersServer());
    }

    @Override
    protected void takeDown() {
        myGui.dispose();
        System.out.println("Seller-agent " + getAID().getName() + " terminating.");
    }

    public void updateCatalogue(String title, int price) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                catalogue.put(title, price);
            }
        });
    }

    public class OfferRequestsServer extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage msg = myAgent.receive();
            if (nonNull(msg)) {
                String title = msg.getContent();
                ACLMessage reply = msg.createReply();

                Integer price = catalogue.get(title);
                if (nonNull(price)) {
                    reply.setPerformative(ACLMessage.PROPOSE);
                    reply.setContent(String.valueOf(price));
                } else {
                    reply.setPerformative(ACLMessage.REFUSE);
                    reply.setContent("not-available");
                }
                myAgent.send(reply);
            }
        }
    }

    public class PurchaseOrdersServer extends CyclicBehaviour {
        @Override
        public void action() {
            ACLMessage msg = myAgent.receive();
            if (nonNull(msg)) {
                String title = msg.getContent();
                ACLMessage reply = msg.createReply();

                Integer price = catalogue.get(title);
                if (nonNull(price)) {
                    reply.setPerformative(ACLMessage.INFORM);
                    System.out.println(title + " sold to agent " + msg.getSender().getName());
                } else {
                    reply.setPerformative(ACLMessage.FAILURE);
                    reply.setContent("not-available");
                }
                myAgent.send(reply);
            }
        }
    }
}
