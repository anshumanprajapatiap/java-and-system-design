package com.anshumanprajapati.indmoney.round2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();

        map.put("A", map.getOrDefault("A", 0.00)-1.00); map.put("B", map.getOrDefault("B", 0.00)+ 1.00);
        map.put("B", map.getOrDefault("B", 0.00)-1.00); map.put("C", map.getOrDefault("C", 0.00)+1.00);
        map.put("C", map.getOrDefault("C", 0.00)-1.00); map.put("A", map.getOrDefault("A", 0.00)+1.00);
        map.put("C", map.getOrDefault("C", 0.00)-1.00); map.put("D", map.getOrDefault("D", 0.00)+1.00);
        map.put("D", map.getOrDefault("D", 0.00)-1.00); map.put("B", map.getOrDefault("B", 0.00)+1.00);

        for(Map.Entry<String, Double> entry: map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // req

    // mutli user
    // group
    // individual transaction

    // user -> splitwise -> individual -> settle
    // user -> application -> group// (A, B, C) -> settle


    // Entity

    // User
    // Transaction
    // Trans Type
    // Group
    // Client App



}


class SplitApp{
    List<User> users;
    List<Transaction> transactions;
    List<Group> groups;

    public SplitApp(){
        this.users = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    public void addUser(String name){
        users.add(new User(users.size()+1, name));
    }

    public void addGroup(String name){
        groups.add(new Group(groups.size()+1, name));
    }

    public void makeTransaction(String title, TransType type, double amount, int paidBy, int paidFor){
        Transaction newTrans = new Transaction(transactions.size()+1, title, amount, type, paidBy, paidFor);
        if(type == TransType.INDIVIDUAL){
            //
        }else{

        }
    }


    public void smplify(){
        // A -> B  (100)
        // B -> C (100)
        // C - A (100)
        // C - D (200)
        // D - B (80)

        // B -> 1 + 1 => 2
        // A -> -1 + 1 => 0
        // C -> -1 - 1 => -2
        // D -> -1 + 1 => 0

        // NET AMOUNT SHOULD BE ZERO
        Map<String, Double> map = new HashMap<>();

        map.put("A", map.getOrDefault("A", 0.00)-1.00); map.put("B", map.getOrDefault("B", 0.00)+ 1.00);
        map.put("B", map.getOrDefault("B", 0.00)-1.00); map.put("C", map.getOrDefault("C", 0.00)+1.00);
        map.put("C", map.getOrDefault("C", 0.00)-1.00); map.put("A", map.getOrDefault("A", 0.00)+1.00);
        map.put("C", map.getOrDefault("C", 0.00)-1.00); map.put("D", map.getOrDefault("D", 0.00)+1.00);
        map.put("D", map.getOrDefault("D", 0.00)-1.00); map.put("B", map.getOrDefault("B", 0.00)+1.00);

        for(Map.Entry<String, Double> entry: map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }


}


enum TransType{
    INDIVIDUAL,
    GROUP;
}


class User{
    private int id;
    private String name;
    private List<String> groupIds;
    private List<Transaction> transactions;

    public User(int id, String name){
        this.id = id;
        this.name = name;
        this.groupIds = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }

}

class Group{
    private int groupId;
    private String name;
    private List<Integer> participants;

    Group(int id, String name){
        this.groupId = id;
        this.name = name;
        this.participants = new ArrayList<>();
    }

    public void addMember(Integer id){
        participants.add(id);
    }
}

class Transaction {
    private int transactionId;
    private String title;
    double amount;
    TransType type;
    int payedBy;
    int payedFor;
    int groupId;

    public Transaction(int id, String title, double amount, TransType type, int payedBy, int payedFor) {
        this.transactionId = id;
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.payedBy = payedBy;
        if (type == TransType.GROUP) {
            this.groupId = payedFor;
        } else {
            this.payedFor = payedFor;
        }
    }
}
