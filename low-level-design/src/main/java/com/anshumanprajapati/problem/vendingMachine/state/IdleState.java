package com.anshumanprajapati.problem.vendingMachine.state;

import com.anshumanprajapati.problem.vendingMachine.Coin;
import com.anshumanprajapati.problem.vendingMachine.VendingMachine;

public class IdleState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        machine.addBalance(coin.getValue());
        machine.setState(new HasMoneyState());
        System.out.println("Coin accepted. Current balance: " + machine.getBalance());
    }

    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("Insert coin first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Insert coin and select item first.");
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("Nothing to cancel.");
    }
}
