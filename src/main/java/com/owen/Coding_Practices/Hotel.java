package com.owen.Coding_Practices;

public class Hotel {
}

interface BaseRoomCharge {
    Double getCost();
}

class RoomCharge implements BaseRoomCharge {
    double cost;
    @Override
    public Double getCost() {
        return cost;
    }
    void setCost(double cost) {
        this.cost = cost;
    }
}

class RoomTotalCharge implements BaseRoomCharge {
    double serviceCost;
    RoomCharge roomCharge;
    @Override
    public Double getCost() {
        roomCharge.setCost(roomCharge.getCost() + serviceCost);
        return roomCharge.getCost();
    }

}

