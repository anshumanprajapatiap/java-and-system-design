package com.anshumanprajapati.mutlithreading.producerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	
	private Queue<Integer> q;
	
	private int capacity;
	
	public BlockingQueue(int cap) {
		q = new LinkedList<>();
		capacity = cap;
	}
	
	public boolean add(int element) {
		synchronized (q) {
			while(q.size()==capacity) {
				try {
					q.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			q.add(element);
            System.out.println("Adding element "+ element);
			q.notifyAll();
			return true;
			
		}
		
	}
	
	public int remove() {
		synchronized (q) {
			while(q.size()==0) {
				try {
					q.wait();
					
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			int element =  q.poll();
            System.out.println("Removing element "+ element);
			q.notifyAll();
			return element;
		}
		
	}


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue(5);

        Thread t1 = new Thread(() ->{
            int itr = 0;
            while(itr++<100){
                blockingQueue.add(itr);
            }
        });

        Thread t2 = new Thread(() ->{
            int itr = 0;
            while(itr++<100){
                int val = blockingQueue.remove();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
