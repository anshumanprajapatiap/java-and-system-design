package com.anshumanprajapati.designpattern.behavioural.mediatordesignpattern;

public class Bider implements  Collegue{
    String name;
    Mediator auctionManager;

    Bider(String name, Mediator auctionManager){
        this.name = name;
        this.auctionManager = auctionManager;
    }

    @Override
    public void sendBid(int amount) {
        auctionManager.acceptBid(this, amount);
    }

    @Override
    public void notifyBid(Collegue collegue, int amount) {
        System.out.println(collegue.getName() + " placed bit for: " + amount);
    }

    @Override
    public String getName() {
        return name;
    }
}
