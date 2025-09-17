package com.anshumanprajapati.designpattern.behavioural.mediatordesignpattern;

import java.util.ArrayList;
import java.util.List;

public class AuctionManager implements  Mediator{

    List<Collegue> collegueList;
    AuctionManager(){
        this.collegueList = new ArrayList<>();
    }
    @Override
    public void addCollegue(Collegue collegue) {
        collegueList.add(collegue);
    }

    @Override
    public void acceptBid(Collegue collegue, int amount) {
        System.out.println("-------------------------------------");
        for(Collegue c: collegueList){
            if(!c.equals(collegue)) collegue.notifyBid(collegue, amount);
        }
        System.out.println("-------------------------------------");
    }
}
