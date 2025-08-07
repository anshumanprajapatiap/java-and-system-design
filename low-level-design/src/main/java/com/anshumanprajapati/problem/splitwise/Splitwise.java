package com.anshumanprajapati.problem.splitwise;

import java.util.*;

public class Splitwise {
    Map<String, User> userMap;
    SimplifyDebt simplifyDebt;
    Splitwise(){
        this.userMap = new HashMap<>();
        this.simplifyDebt = new SimplifyDebt(userMap);
    }

    public void addUser(User user){
        userMap.put(user.getName(), user);
    }

    public void makeTransaction(String payedBy, String payedFor, double amount){
        userMap.computeIfAbsent(payedBy, k -> new User(payedBy, 0)).update(-amount);
        userMap.computeIfAbsent(payedFor, k -> new User(payedFor, 0)).update(amount);
    }

    public void simplify(){
        simplifyDebt.simplify();
    }

    public Map<String, User> getDetails(){
        return this.userMap;
    }

    public void printCurrentBalance(){
        System.out.println("-----------------------------------------------");
        for(Map.Entry<String, User> entry: userMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("-----------------------------------------------");
    }
}
