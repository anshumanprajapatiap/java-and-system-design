package com.anshumanprajapati.here.round3R2;


// Pattern is a creational design pattern and this pattern will Initialize object only once 
// in memory


// difference by interfance and abstract class

// difference by hascode and equals on hashmap

// Worked with AWS ? - NO

// Worked with DATABASE ? - YES

public class SingletonPattern {
	
	static volatile String lock = null;
	
	
	String create(String value){
		if(lock==null) {
			synchronized (lock) {
				if(lock==null) {
					value = "CREATED";
				}
				
				
			}
		}
		return value;
		
	}


}
