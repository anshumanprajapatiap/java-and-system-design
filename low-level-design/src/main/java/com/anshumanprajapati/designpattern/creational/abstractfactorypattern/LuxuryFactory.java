package com.anshumanprajapati.designpattern.creational.abstractfactorypattern;

public class LuxuryFactory {

    Vehicle getVehicle(String input){
        switch (input){
            case "MERCEDES":
                return new Mercedes();
            case "BMW":
                return new BMW();
            default:
                return null;
        }
    }
}
