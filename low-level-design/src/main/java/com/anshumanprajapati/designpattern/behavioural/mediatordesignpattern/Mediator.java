package com.anshumanprajapati.designpattern.behavioural.mediatordesignpattern;

public interface Mediator {

    public void addCollegue(Collegue collegue);
    public void acceptBid(Collegue collegue, int amount);
}
