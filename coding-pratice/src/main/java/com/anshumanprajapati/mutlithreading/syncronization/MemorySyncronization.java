package com.anshumanprajapati.mutlithreading.syncronization;

public class MemorySyncronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Main Thread Starting");
		
		
		Stack stack = new Stack(5);
		
		new Thread(()->{
			int counter = 0;
			while(++counter<10) 
				System.out.println("Pushed "+ stack.push(100));
			
		}, "Pusher").start();
		
		
		new Thread(()->{
			int counter = 0;
			while(++counter<10) 
				System.out.println("Popped "+ stack.pop());
			
		}, "Popper").start();
		/*
		 * syncronized method do not required lock
		 * syncronized block required lock,
		 * as method used current object as lock
		 */
		
		System.out.println("Main Thread Ending");
		
	}

}
