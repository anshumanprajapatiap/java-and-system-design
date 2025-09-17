package com.anshumanprajapati.mutlithreading.producerConsumerProblem;

class Q{
    int num;
    boolean valueSet = false;

    public synchronized void put(int num){

        while (valueSet){
            try{
                wait();;
            }catch (Exception e){

            }
        }
        System.out.println("Put : " + num);
        this.num = num;
        valueSet = true;
        notify();
    }
    public synchronized void get(){
        while (!valueSet){
            try{
                wait();;
            }catch (Exception e){

            }
        }
        System.out.println("Get : " + num);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable{
    Q q;
    Producer(Q q){
        this.q = q;
        Thread thread = new Thread(this, "Producer");
        thread.start();
    }
    @Override
    public void run() {
        int i = 0;
        while(true){
            try{
                q.put(i++);
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}

class Consumer implements Runnable{
    Q q;
    Consumer(Q q){
        this.q = q;
        Thread thread = new Thread(this, "Consumer");
        thread.start();
    }
    @Override
    public void run() {
        while(true) {
            try{
                q.get();
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}

public class ConsumerProducer {

    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
