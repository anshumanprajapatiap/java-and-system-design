package com.anshumanprajapati.LowLevelDesign.DesignPatterns.AdapterDesignPattern.Adaptee;

public class WeightMachineForBabies implements WeightMachine{
    @Override
    public double getWeightInPound() {
        return 28;
    }
}
