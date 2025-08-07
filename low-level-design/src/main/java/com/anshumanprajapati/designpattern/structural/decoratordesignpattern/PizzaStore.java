package com.anshumanprajapati.designpattern.structural.decoratordesignpattern;

import com.anshumanprajapati.designpattern.structural.decoratordesignpattern.decorator.ExtraCheesse;
import com.anshumanprajapati.designpattern.structural.decoratordesignpattern.decorator.Mashrooms;

public class PizzaStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BasePizza basepizza = new ExtraCheesse(new Mashrooms(new Mashrooms( new VeggiDelightPizza())));
		System.out.println(basepizza.cost());


	}

}
