package com.anshumanprajapati.problem.vendingMachine;

import com.anshumanprajapati.problem.vendingMachine.state.IdleState;
import com.anshumanprajapati.problem.vendingMachine.state.VendingMachineState;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class VendingMachine {
    private Inventory<Item> itemInventory;
    @Setter
    private VendingMachineState state;
    @Getter
    private int balance;
    @Setter
    @Getter
    private Item selectedItem;

    VendingMachine(){
        this.itemInventory = new Inventory<>();
        this.state = new IdleState();
        this.balance = 0;
    }

    public void insertCoin(Coin coin) {
        state.insertCoin(this, coin);
    }

    public void selectItem(String code) {
        state.selectItem(this, code);
    }

    public void dispenseItem() {
        state.dispenseItem(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void addBalance(int amount) {
        System.out.println("Amount added on machine " + amount);
        this.balance += amount;
    }

    public void deductBalance(int amount) {
        this.balance -= amount;
    }

    public void reset() {
        this.balance = 0;
        this.selectedItem = null;
    }

    public void loadItem(Item item){
        itemInventory.add(item.getCode(), item);
    }

    public  Map<String, Item>  getItemInventory() {
        return itemInventory.getItems();
    }
}
