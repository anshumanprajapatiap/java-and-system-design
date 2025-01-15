package com.anshumanprajapati.designpattern.behavioural.observerdesignpattern.observable;

import com.anshumanprajapati.designpattern.behavioural.observerdesignpattern.observer.NotificationAlertObserver;

public interface StockObservable {
	
	
	public void add(NotificationAlertObserver observer);
	
	public void remove(NotificationAlertObserver observer);
	
	public void notifySubscriber();
	
	public void setStockCount(int newStockAdded);
	
	public int getStockCount();

}
