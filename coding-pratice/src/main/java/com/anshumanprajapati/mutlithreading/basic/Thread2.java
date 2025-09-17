package com.anshumanprajapati.mutlithreading.basic;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<5; i++) {
			System.out.println("Inside "+ Thread.currentThread().getName() +" "+ i);
		}
	}

}
