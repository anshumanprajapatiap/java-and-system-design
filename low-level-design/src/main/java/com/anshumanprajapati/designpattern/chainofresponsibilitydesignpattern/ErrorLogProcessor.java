package designpattern.chainofresponsibilitydesignpattern;

public class ErrorLogProcessor extends LogProcessor{
	
	public ErrorLogProcessor(LogProcessor nextLogProcessor) {
		// TODO Auto-generated constructor stub
		super(nextLogProcessor);
	}
	
	public void log(int logLevel, String message) {
		
		if(logLevel == ERROR) {
			System.out.println("ERROR: "+ message);
		} else {
			super.log(logLevel, message);
		}
	}

}
