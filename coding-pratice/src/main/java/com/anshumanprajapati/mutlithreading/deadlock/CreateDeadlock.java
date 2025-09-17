package com.anshumanprajapati.mutlithreading.deadlock;

public class CreateDeadlock {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		System.out.println("Main Starting");
		
		
		String lock1 = "lock1";
		String lock2 = "lock2";
		
		Thread thread1 = new Thread(()->{
			
			synchronized (lock1) {
				try {
					
					System.out.println("lock 1 by thread 1");
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (lock2) {
					System.out.println("Lock Acquired");
				}
				
			}
			
		},"Thread1");
		
		
		Thread thread2 = new Thread(()->{
			
			synchronized (lock2) {
				try {
					System.out.println("lock 2 by thread 2");
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (lock1) {
					System.out.println("Lock Acquired");
				}
				
			}
			
		},"Thread2");
		
		
		thread1.start(); 
		thread2.start();

		thread1.join();
		thread2.join();

		
		System.out.println("Main exit");

	}

}
