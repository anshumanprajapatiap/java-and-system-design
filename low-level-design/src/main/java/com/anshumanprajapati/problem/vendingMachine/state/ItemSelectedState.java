package com.anshumanprajapati.problem.vendingMachine.state;

import com.anshumanprajapati.problem.vendingMachine.Coin;
import com.anshumanprajapati.problem.vendingMachine.Item;
import com.anshumanprajapati.problem.vendingMachine.VendingMachine;

public class ItemSelectedState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("Item already selected. Cannot add more coins.");
    }

    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        Item item = machine.getSelectedItem();
        int price = item.getPrice();
        machine.deductBalance(price);
        item.decreaseQuantity();
        System.out.println("Dispensing: " + item.getName());

        if (machine.getBalance() > 0) {
            System.out.println("Returning change: " + machine.getBalance());
        }

        machine.reset();
        machine.setState(new IdleState());
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("Transaction cancelled. Returning: " + machine.getBalance());
        machine.reset();
        machine.setState(new IdleState());
    }
}
