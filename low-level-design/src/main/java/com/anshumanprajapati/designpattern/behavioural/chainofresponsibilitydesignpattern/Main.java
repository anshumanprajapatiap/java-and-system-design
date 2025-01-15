package com.anshumanprajapati.designpattern.behavioural.chainofresponsibilitydesignpattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		
		
		logger.log(LogProcessor.INFO, "This is in info");
		logger.log(LogProcessor.DEBUG, "This is in DEBUG");
		logger.log(LogProcessor.ERROR, "This is in ERROR");
	}

}
