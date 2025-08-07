package com.anshumanprajapati.problem.parkinglot.object;

import com.anshumanprajapati.problem.parkinglot.object.Vehicle;
import com.anshumanprajapati.problem.parkinglot.enums.VehicleType;

public class ParkingSpot {
    private final int id;
    boolean isEmpty;
    Vehicle vehicle;
    private final int price;
    private final VehicleType parkingSpotType;

    public ParkingSpot(int id, int price, VehicleType parkingSpotType){
        this.id = id;
        this.isEmpty = true;
        this.vehicle = null;
        this.price = price;
        this.parkingSpotType = parkingSpotType;
    }

    public int getPrice(){
        return price;
    }

    public boolean matchVehicleType(Vehicle vehicle){
        if(vehicle.vehicleType.equals(parkingSpotType)) return true;
        return false;

    }

    public void parkVehicle(Vehicle v){
        this.vehicle = v;
        this.isEmpty = false;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.isEmpty = true;
    }
}
