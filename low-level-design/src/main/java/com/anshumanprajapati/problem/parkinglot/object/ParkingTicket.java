package com.anshumanprajapati.problem.parkinglot.object;

import org.joda.time.DateTime;

public class ParkingTicket {
    DateTime entryTime;
    DateTime exitTime;
    ParkingSpot parkingSpot;

    public ParkingTicket(DateTime entryTime, DateTime exitTime, ParkingSpot parkingSpot){
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.parkingSpot = parkingSpot;
    }

}
