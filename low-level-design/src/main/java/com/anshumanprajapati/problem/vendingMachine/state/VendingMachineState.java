package com.anshumanprajapati.problem.vendingMachine;

public interface VendingMachineState {
    void insertCoin(VendingMachine machine, Coin coin);
    void selectItem(VendingMachine machine, String itemCode);
    void dispenseItem(VendingMachine machine);
    void cancel(VendingMachine machine);
}
