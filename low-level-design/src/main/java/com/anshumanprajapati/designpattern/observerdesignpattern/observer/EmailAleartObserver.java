package designpattern.observerdesignpattern.observer;

import designpattern.observerdesignpattern.observable.StockObservable;

public class EmailAleartObserver implements NotificationAlertObserver{
	
	String emailId;
	StockObservable stockObservable;
	
	
	public EmailAleartObserver(String email, StockObservable observable) {
		this.emailId = email;
		this.stockObservable = observable;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		sendEmail(emailId, "Product is in stock hurry up!");
	}


	private void sendEmail(String emailId, String string) {
		// TODO Auto-generated method stub
		
		System.out.println("Emial has been send to " + emailId);
		
	}
	
	
	

}
