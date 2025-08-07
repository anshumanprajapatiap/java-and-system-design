package com.anshumanprajapati.problem.vendingMachine;

public class Main {

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.loadItem(new Item("A1", "Coke", 10, 5));
        vm.loadItem(new Item("B1", "Pepsi", 15, 3));

        vm.insertCoin(Coin.TEN);
        vm.selectItem("A1");
        vm.dispenseItem();  // Should dispense Coke

        vm.insertCoin(Coin.FIVE);
        vm.cancel();
    }
}
