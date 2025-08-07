package com.anshumanprajapati.problem.vendingMachine;

import java.util.*;

public class Inventory<T extends Item> {
    private Map<String, T> items;

    Inventory(){
        items = new HashMap<>();
    }

    public void add(String itemCode, T item) {
        items.put(itemCode, item);
    }

    public void deduct(String itemCode) {
        if (!items.containsKey(itemCode)) {
            throw new IllegalStateException("Item not available in inventory");
        }

        T item = items.get(itemCode);
        if (item.getQuantity() <= 0) {
            throw new IllegalStateException("Item is out of stock");
        }

        item.decreaseQuantity();
    }

    public int getQuantity(String itemCode) {
        if (!items.containsKey(itemCode)) {
            return 0;
        }
        return items.get(itemCode).getQuantity();
    }


    public Map<String, T> getItems() {
        return this.items;
    }

    public T getItem(String itemCode) {
        return items.get(itemCode);
    }


}
