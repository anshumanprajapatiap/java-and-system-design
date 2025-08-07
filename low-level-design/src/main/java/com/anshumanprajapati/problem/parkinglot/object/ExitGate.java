package com.anshumanprajapati.problem.parkinglot.object;

import java.util.List;

public class ExitGate {
    List<ParkingSpot> parkingSpotList;

    ExitGate(List<ParkingSpot> parkingSpotList){
        this.parkingSpotList = parkingSpotList;
    }

    public ParkingSpot findParkingSpot(Vehicle v){
        for(ParkingSpot parkingSpot: parkingSpotList){
            if(parkingSpot.isEmpty && parkingSpot.matchVehicleType(v)){
                return parkingSpot;
            }
        }
        return null;
    }

    public void updateParkingSpot(ParkingTicket parkingTicket){
        parkingTicket.parkingSpot.removeVehicle();
    }

//    public int calculateCost(ParkingTicket parkingTicket){
//        return (parkingTicket.exitTime - parkingTicket.entryTime ) * parkingTicket.parkingSpot.getPrice();
//    }
}
