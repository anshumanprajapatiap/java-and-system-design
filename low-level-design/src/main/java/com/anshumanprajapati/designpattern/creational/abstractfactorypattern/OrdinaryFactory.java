package com.anshumanprajapati.designpattern.creational.abstractfactorypattern;

public class OrdinaryFactory {

    Vehicle getVehicle(String input){
        switch (input){
            case "SWIFT":
                return new Mercedes();
            case "CRETA":
                return new BMW();
            default:
                return null;
        }
    }
}
