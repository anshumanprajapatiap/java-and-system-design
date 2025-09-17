package com.anshumanprajapati.designpattern.behavioural.mediatordesignpattern;



public class AuctionSystem {

    public static void main(String[] args) {
        Mediator mediator = new AuctionManager();
        Collegue b1 = new Bider("b1", mediator);
        Collegue b2 = new Bider("b2", mediator);
        Collegue b3 = new Bider("b3", mediator);
        Collegue b4 = new Bider("b4", mediator);
        mediator.addCollegue(b1);
        mediator.addCollegue(b2);
        mediator.addCollegue(b3);
        mediator.addCollegue(b4);

        b1.sendBid(100);
        b2.sendBid(200);
        b3.sendBid(400);


    }
}
