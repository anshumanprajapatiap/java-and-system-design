package com.anshumanprajapati.problem.splitwise;

import java.util.*;

public class SimplifyDebt {
    Map<String, User> userMap;

    SimplifyDebt(Map<String, User> userMap){
        this.userMap = userMap;
    }

    public void simplify(){
        List<User> creditors = new ArrayList<>();
        List<User> debtors = new ArrayList<>();
        makeList(creditors, debtors);

        int i=0, j=0;
        while(i<creditors.size() && j<debtors.size()){
            User creditor = creditors.get(i);
            User debtor = debtors.get(j);

            double credit = Math.abs(creditor.getBalance()); // person should receive
            double debt = Math.abs(debtor.getBalance());     // person should pay

            double settledAmount = Math.min(credit, debt);

            // Settle amount
            System.out.println(debtor.getName() + " pays ₹" + settledAmount + " to " + creditor.getName());

            // Update balances
            creditor.setBalance(credit - settledAmount);
            debtor.setBalance(debt - settledAmount);

            // Update in map explicitly (optional, for clarity)
            userMap.put(creditor.getName(), creditor);
            userMap.put(debtor.getName(), debtor);

            // Move pointers
            if (Math.abs(creditor.getBalance()) < 1e-6) i++;
            if (Math.abs(debtor.getBalance()) < 1e-6) j++;
        }

    }

    public void makeList(List<User> creditor, List<User> debtor ){

        for(Map.Entry<String, User> entry: userMap.entrySet()){
            if(entry.getValue().getBalance() < 0){
                creditor.add(entry.getValue());
            }else if(entry.getValue().getBalance() > 0){
                debtor.add(entry.getValue());
            }
        }
    }
}
