package designpattern.chainofresponsibilitydesignpattern;

public class DebugLogProcessor extends LogProcessor{
	
	public DebugLogProcessor(LogProcessor nextLogProcessor) {
		// TODO Auto-generated constructor stub
		super(nextLogProcessor);
	}
	
	public void log(int logLevel, String message) {
		
		if(logLevel == DEBUG) {
			System.out.println("DEBUG: "+ message);
		} else {
			super.log(logLevel, message);
		}
	}

}
