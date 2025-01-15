package com.anshumanprajapati.designpattern.behavioural.chainofresponsibilitydesignpattern;

public abstract class LogProcessor {
	
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	
	LogProcessor nextLogProcessor;
	
	LogProcessor(LogProcessor nextProcessor){
		this.nextLogProcessor = nextProcessor;
	}
	
	public void log(int logLevel, String message) {
		
		if(nextLogProcessor != null) {
			nextLogProcessor.log(logLevel, message);
		}
	}

}
