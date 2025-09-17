package com.anshumanprajapati;


abstract class Car{
	private String carName;
	
	Car(String carName){
		this.carName = carName;
	}
	
	public abstract void drive();
	public abstract void fly();
	
	public void playMusic() {
		System.out.println("Play music....");
	}
	
	public String getCarName() {
		return this.carName;
	}
	
}

abstract class WagonR extends Car{

	WagonR() {
		super("Wagon R");
		// TODO Auto-generated constructor stub
	}

	public void drive() {
		System.out.println("drive....");
		
	}

	public String getCarName() {
		return super.getCarName();
	}
	
}

// Concreate class
class UpdatedWangonR extends WagonR{ 

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("fly....");
		
	}
	
}





public class Abstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Car c = new UpdatedWangonR();
		c.drive();
		c.fly();
		System.out.println(c.getCarName());
		
	}

}
