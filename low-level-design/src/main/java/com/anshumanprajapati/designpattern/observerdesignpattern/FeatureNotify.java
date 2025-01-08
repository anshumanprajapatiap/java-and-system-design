package designpattern.observerdesignpattern;

import designpattern.observerdesignpattern.observable.IphoneObservable;
import designpattern.observerdesignpattern.observable.StockObservable;
import designpattern.observerdesignpattern.observer.EmailAleartObserver;
import designpattern.observerdesignpattern.observer.MobileAleartObserver;
import designpattern.observerdesignpattern.observer.NotificationAlertObserver;

public class FeatureNotify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StockObservable iphoneStockObservable = new IphoneObservable();
		
		
		NotificationAlertObserver  observer1 = new EmailAleartObserver("abc@gmail.com,", iphoneStockObservable);
		NotificationAlertObserver  observer2 = new EmailAleartObserver("def@gmail.com,", iphoneStockObservable);
		NotificationAlertObserver  observer3 = new MobileAleartObserver("anshuman,", iphoneStockObservable);

		
		
		
		iphoneStockObservable.add(observer1);
		iphoneStockObservable.add(observer2);
		iphoneStockObservable.add(observer3);
		
		iphoneStockObservable.setStockCount(10);
		

	}

}
