package com.anshumanprajapati.problem.parkinglot.object;


import java.util.List;

public class EntryGate {
    List<ParkingSpot> parkingSpotList;

    EntryGate(List<ParkingSpot> parkingSpotList){
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

    public void updateParkingSpot(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpot.parkVehicle(vehicle);
    }
}
