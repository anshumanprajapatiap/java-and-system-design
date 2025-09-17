package com.anshumanprajapati.mutlithreading.basic;

public class ThreadTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Main Thread Starting");
		
//		Thread task1 = new Thread1("Thread 1");
//		task1.start();
		
//		Thread task2 = new Thread(new Thread2(), "Thread 2");
//		task2.start();
		
	
		//Which one is better 
		/*
		 * Runnable is Interface and we can extend multiple interfaces in java
		 * Hence we should use Interface if we want to extend more Interfaces 
		 * Runnable is used in current Organization as well.
		 * 
		 */
		
		
		Thread task2 = new Thread(() ->{
			
			for(int i=0; i<5; i++) {
				System.out.println("Inside "+ Thread.currentThread().getName() +" "+ i);
			}
			
		}, "Thread 2");
		task2.start();
		try {
			task2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Main Thread Ending");

	}

}
