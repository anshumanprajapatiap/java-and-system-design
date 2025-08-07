package com.anshumanprajapati.problem.splitwise;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String name;
    double balance;

    public void update(double amount){
        balance += amount;
    }
}
