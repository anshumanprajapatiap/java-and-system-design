package com.anshumanprajapati.solid.dependencyInversion;

public class MacBook {

    private final Mouse mouse;
    private final Keyboard keyboard;

    public MacBook(Mouse mouse, Keyboard keyboard){
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}

interface Mouse{

}


interface Keyboard{

}