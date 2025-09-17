package com.anshumanprajapati.walmart.ijp.ijp1;

import java.util.ArrayList;
import java.util.List;

public class Round2 {
}

// -> adding transation -> rule(customer) -> yes/no

class Application{
    Rule rule;
    List<Transaction> transactions = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    Application(){
        this.rule = new Rule1(new Rule2(null));
    }

    void addTransaction(Transaction t){
        this.transactions.add(t);
    }

    void addCustomer(Customer c){
        this.customers.add(c);
    }

    boolean detectFraud(String customerId){
        List<Transaction> customerTrans = transactions;
        return false;
    }
}



class Transaction{
    String customerId;
}
class Customer{

}

abstract class Rule{
    public boolean getFraud(List<Transaction> transactions, Customer customer){
        return true;
    }
}

class Rule1 extends Rule{
    Rule nextRule;

    Rule1(Rule rule){
        this.nextRule = rule;
    }

    @Override
    public boolean getFraud(List<Transaction> transactions, Customer customer){
        if(condition()){
            if(nextRule==null) return true;
            return nextRule.getFraud(transactions, customer);
        }
        return false;
    }

    public boolean condition(){
        return true;
    }

}

class Rule2 extends Rule{
    Rule nextRule;

    Rule2(Rule rule){
        this.nextRule = rule;
    }

    @Override
    public boolean getFraud(List<Transaction> transactions, Customer customerId){
        if(condition()){
            if(nextRule==null) return true;
            return nextRule.getFraud(transactions, customerId);
        }
        return false;
    }

    public boolean condition(){
        return false;
    }

}

// rule1 ->  rule2 -> rule3 ->