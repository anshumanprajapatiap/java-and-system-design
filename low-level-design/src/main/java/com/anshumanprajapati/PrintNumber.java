package com.anshumanprajapati;

public class PrintNumber {

    private static void increment(int[] arr){
        arr[0]++;
    }

    public static void main(String[] args) {
        final int[] num = new int[]{1};
        final int maxNumber = 30;
        final int numberOfThread = 3;
        Thread[] threads = new Thread[numberOfThread];

        for(int i=0; i<numberOfThread; i++){
            final int idx = i;

            threads[i] = new Thread(() -> {
                while (true) {
                    synchronized (num) {
                        if (num[0] > maxNumber) break;

                        if (num[0] % numberOfThread == idx) {
                            System.out.println("Thread " + idx + " : " + num[0]);
                            increment(num);
                        }
                    }
                }
            });
        }

        for(Thread t: threads) t.start();
    }
}


