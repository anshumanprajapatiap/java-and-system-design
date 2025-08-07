package com.anshumanprajapati.problem.vendingMachine.state;

import com.anshumanprajapati.problem.vendingMachine.Coin;
import com.anshumanprajapati.problem.vendingMachine.Item;
import com.anshumanprajapati.problem.vendingMachine.VendingMachine;

public class HasMoneyState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        machine.addBalance(coin.getValue());
        System.out.println("Coin added. Current balance: " + machine.getBalance());
    }

    @Override
    public void selectItem(VendingMachine machine, String itemCode) {
        Item item = machine.getItemInventory().get(itemCode);
        if (item == null || item.getQuantity() <= 0) {
            System.out.println("Item unavailable.");
            return;
        }
        if (machine.getBalance() < item.getPrice()) {
            System.out.println("Insufficient balance.");
            return;
        }
        machine.setSelectedItem(item);
        machine.setState(new ItemSelectedState());
        System.out.println("Item " + item.getName() + " selected.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("Transaction cancelled. Returning: " + machine.getBalance());
        machine.reset();
        machine.setState(new IdleState());
    }
}
