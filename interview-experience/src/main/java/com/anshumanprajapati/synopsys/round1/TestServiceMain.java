package com.anshumanprajapati.synopsys.round1;

public class TestServiceMain {

    public static void main(String[] args) {

        TestA testA = new TestB();

        testA.display();

    }

 

    public static class TestA {

        public void display() {

            System.out.println("TestA: Hello there!...");

        }

    }

 

    public static class TestB extends TestA {
    	
        public void display() {

            System.out.println("TestB: Hi there...");

        }

    }

}
