package designpattern.observerdesignpattern.observer;

import designpattern.observerdesignpattern.observable.StockObservable;

public class MobileAleartObserver implements NotificationAlertObserver {
	
	
	String userName;
	StockObservable stockObservable;
	
	
	public MobileAleartObserver(String userName, StockObservable observable) {
		this.userName = userName;
		this.stockObservable = observable;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		sendMessageOnPhone(userName, "Product is in stock hurry up!");
	}


	private void sendMessageOnPhone(String userName, String msg) {
		// TODO Auto-generated method stub
		
		System.out.println("Message send to mobile " + userName);
		
	}

}
