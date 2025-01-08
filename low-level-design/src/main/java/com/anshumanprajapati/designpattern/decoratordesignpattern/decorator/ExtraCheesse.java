package designpattern.decoratordesignpattern.decorator;

import designpattern.decoratordesignpattern.BasePizza;

public class ExtraCheesse extends PizzaToppingsDecorator{
	
	BasePizza basepizza;
	
	public ExtraCheesse(BasePizza basepizzaInput) {
		// TODO Auto-generated constructor stub
		this.basepizza = basepizzaInput;
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return basepizza.cost() + 50;
	}
	
	

}
