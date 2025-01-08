package designpattern.observerdesignpattern.observable;

import java.util.*;

import designpattern.observerdesignpattern.observer.NotificationAlertObserver;

public class IphoneObservable implements StockObservable{
	
	public List<NotificationAlertObserver>  observerList = new ArrayList<>();
	public int stockCount=0;

	@Override
	public void add(NotificationAlertObserver observer) {
		// TODO Auto-generated method stub
		observerList.add(observer);
	}

	@Override
	public void remove(NotificationAlertObserver observer) {
		// TODO Auto-generated method stub
		observerList.remove(observer);
	}

	@Override
	public void notifySubscriber() {
		// TODO Auto-generated method stub
		for(NotificationAlertObserver observer:observerList) {
			observer.update();
		}
	}

	@Override
	public void setStockCount(int newStockAdded) {
		// TODO Auto-generated method stub
		if(stockCount == 0) {
			notifySubscriber();
		}
		stockCount += newStockAdded;
		
	}

	@Override
	public int getStockCount() {
		// TODO Auto-generated method stub
		return stockCount;
		
	}

}
