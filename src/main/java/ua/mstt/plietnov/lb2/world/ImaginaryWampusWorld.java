package ua.mstt.plietnov.lb2.world;

import ua.mstt.plietnov.lb2.agent.NavigatorAgent;

import java.util.Hashtable;
import java.util.Set;

public class ImaginaryWampusWorld {

    private Hashtable<Position, ImaginaryRoom> worldGrid;
    private boolean isWampusAlive;
    private int wampusRoomCount;
    private Position wampusCoords;

    public ImaginaryWampusWorld() {
        worldGrid = new Hashtable<>();
        isWampusAlive = true;
        wampusRoomCount = 0;
    }

    public Position getWampusCoords() {
        int xWampusCoord = 0;
        int yWampusCoord = 0;

        Set<Position> keys = worldGrid.keySet();
        for (Position roomPosition : keys) {
            ImaginaryRoom room = worldGrid.get(roomPosition);
            if (room.getWampus() == NavigatorAgent.ROOM_STATUS_POSSIBLE) {
                xWampusCoord += roomPosition.getX();
                yWampusCoord += roomPosition.getY();
            }
        }
        xWampusCoord /= wampusRoomCount;
        yWampusCoord /= wampusRoomCount;
        this.wampusCoords = new Position(xWampusCoord, yWampusCoord);
        return this.wampusCoords;
    }

    public Hashtable<Position, ImaginaryRoom> getWorldGrid() {
        return worldGrid;
    }


    public boolean isWampusAlive() {
        return isWampusAlive;
    }

    public void setWampusAlive(boolean wampusAlive) {
        isWampusAlive = wampusAlive;
    }

    public int getWampusRoomCount() {
        return wampusRoomCount;
    }

    public void setWampusRoomCount(int wampusRoomCount) {
        this.wampusRoomCount = wampusRoomCount;
    }
}
