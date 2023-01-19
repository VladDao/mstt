package ua.mstt.plietnov.lb2.state;

import ua.mstt.plietnov.lb2.agent.WampusWorldAgent;

import java.util.ArrayList;

public class Room {
    public ArrayList<String> events = new ArrayList<>();

    public Room(int... args) {
        for (int i : args) {
            events.add(WampusWorldAgent.roomCodes.get(i));
        }
    }
}
