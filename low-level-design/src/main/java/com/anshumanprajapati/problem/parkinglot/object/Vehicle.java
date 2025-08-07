package com.anshumanprajapati.problem.parkinglot.object;

import com.anshumanprajapati.problem.parkinglot.enums.VehicleType;

public class Vehicle {
    String number;
    VehicleType vehicleType;

    public Vehicle(String number, VehicleType vehicleType){
        this.number = number;
        this.vehicleType = vehicleType;
    }
}
