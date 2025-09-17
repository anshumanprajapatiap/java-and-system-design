package com.anshumanprajapati.designpattern.behavioural.mediatordesignpattern;

public interface Collegue {

    public void sendBid(int amount);
    public void notifyBid(Collegue collegue, int amount);
    public String getName();
}
