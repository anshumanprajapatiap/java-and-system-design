package designpattern.decoratordesignpattern;

import designpattern.decoratordesignpattern.decorator.ExtraCheesse;
import designpattern.decoratordesignpattern.decorator.Mashrooms;

public class PizzaStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BasePizza basepizza = new Mashrooms(new Mashrooms( new VeggiDelightPizza()));
		System.out.println(basepizza.cost());

	}

}
