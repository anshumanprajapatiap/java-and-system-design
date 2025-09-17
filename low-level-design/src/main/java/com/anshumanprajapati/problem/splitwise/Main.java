package com.anshumanprajapati.problem.splitwise;

public class Main {


    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise();

        splitwise.addUser(new User("A", 0));
        splitwise.addUser(new User("B", 0));
        splitwise.addUser(new User("C", 0));
        splitwise.addUser(new User("d", 0));
        splitwise.printCurrentBalance();

        splitwise.makeTransaction("A", "B", 10);
        splitwise.makeTransaction("A", "B", 10);
        splitwise.makeTransaction("B", "C", 20);
        splitwise.makeTransaction("B", "C", 20);
        splitwise.makeTransaction("C", "A", 20);

        splitwise.printCurrentBalance();

        splitwise.simplify();


        splitwise.printCurrentBalance();

    }
}
