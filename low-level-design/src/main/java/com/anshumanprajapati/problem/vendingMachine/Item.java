package com.anshumanprajapati.problem.vendingMachine;

import lombok.Data;

public class Item {
    private String code;
    private String name;
    private int price;
    private int quantity;

    public Item(String code, String name, int price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void decreaseQuantity() {
        if (quantity <= 0) {
            throw new IllegalStateException("Item is out of stock");
        }
        quantity--;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
