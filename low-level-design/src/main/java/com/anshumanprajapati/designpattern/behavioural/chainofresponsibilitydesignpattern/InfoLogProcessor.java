package com.anshumanprajapati.designpattern.behavioural.chainofresponsibilitydesignpattern;

public class InfoLogProcessor extends LogProcessor{
	
	public InfoLogProcessor(LogProcessor nextLogProcessor) {
		// TODO Auto-generated constructor stub
		super(nextLogProcessor);
	}
	
	public void log(int logLevel, String message) {
		
		if(logLevel == INFO) {
			System.out.println("INFO: "+ message);
		} else {
			super.log(logLevel, message);
		}
	}

}
