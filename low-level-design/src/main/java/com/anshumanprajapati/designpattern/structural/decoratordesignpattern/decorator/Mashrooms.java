package com.anshumanprajapati.designpattern.structural.decoratordesignpattern.decorator;

import com.anshumanprajapati.designpattern.structural.decoratordesignpattern.BasePizza;

public class Mashrooms extends PizzaToppingsDecorator{
	
	BasePizza basepizza;
	
	public Mashrooms(BasePizza basepizzaInput) {
		// TODO Auto-generated constructor stub
		this.basepizza = basepizzaInput;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return basepizza.cost() + 30;
	}
	
	

}
