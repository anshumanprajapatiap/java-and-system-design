package com.anshumanprajapati;

import java.util.Comparator;

@FunctionalInterface
interface FunInterface{
	
	
	void def();
	
//	void def2(); // CAN NOT CREATE 2 METHODS
	
}


class NewRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	void stop() {
		
	}
}


class CustomComparable implements Comparable{

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class CustomComparator implements Comparator<Object>{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}





public class Annotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
