package com.anshumanprajapati;

interface DomesticAnimal{
	void behaviour();
}
class Animal{
	
	void eat() {
		System.out.println("eat");
	}
}
class Dog extends Animal implements DomesticAnimal{
	
	void eat() {
		System.out.println("dog eating");
	}

	@Override
	public void behaviour() {
		// TODO Auto-generated method stub
		System.out.println("very good");
		
	}
}



public class Polymorphism {
	
	public static void main(String[] args) {
		Animal a = new Animal();
		a.eat();
		
		Animal d = new Dog(); // UPCASTING
		d.eat();
		
		
		Dog d2 = new Dog();
		
		d2.behaviour();
		
		
//		Dog d2 = new Animal(); // DOWNCASTING IS NOT POSSIBLE
		
	}
	

}