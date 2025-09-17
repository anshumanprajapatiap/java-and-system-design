package com.anshumanprajapati.hivepro.round2;

import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

class Utility{

    int[] array;
    int sum;
    int numberOfThread;
    int[] sumArray;
    Utility(int[] array){
     this.array = array;
     this.sum = 0;
     // assigning 4 as number of Threads
     this.numberOfThread = 4;
     sumArray = new int[this.numberOfThread];
    }

    int getConcurrentSum(){

     List<Thread> listOfThread = new ArrayList<>();

     //Creating threads
     int sequenceStart = 0;
     int sequenceEnd = array.length/numberOfThread;
     for(int i=0; i<numberOfThread; i++){
         int idx = i;
         int sS = sequenceStart;
         int sE = sequenceEnd;
         Thread newThread = new Thread(()->{
                                 final int threadIndex =idx;
                                 int current = sS;
                                 int end = sE;
                                 for(int element=current; element<end; element++){
                                    sumArray[threadIndex] += array[element];

                                 }
         });

         listOfThread.add(newThread);
         sequenceStart = sequenceEnd;
         sequenceEnd += array.length/numberOfThread;
         if(sequenceEnd/numberOfThread==array.length/numberOfThread){
             sequenceEnd = array.length;
         }

     }


     // Running all thread in parllel
     for(Thread t: listOfThread){
         t.start();

     }
     // wait thread to execute
     for(Thread t: listOfThread){
         try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     }

     for(int i=0; i<numberOfThread; i++){
         sum += sumArray[i];
     }


     // Returing sum
     return sum;

    }

}
