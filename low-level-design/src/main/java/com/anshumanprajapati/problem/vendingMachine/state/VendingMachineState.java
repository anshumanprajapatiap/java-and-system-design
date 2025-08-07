package com.anshumanprajapati.problem.vendingMachine.state;

import com.anshumanprajapati.problem.vendingMachine.Coin;
import com.anshumanprajapati.problem.vendingMachine.VendingMachine;

public interface VendingMachineState {
    void insertCoin(VendingMachine machine, Coin coin);
    void selectItem(VendingMachine machine, String itemCode);
    void dispenseItem(VendingMachine machine);
    void cancel(VendingMachine machine);
}
