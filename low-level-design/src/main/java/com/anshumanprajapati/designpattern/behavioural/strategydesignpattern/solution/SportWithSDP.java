package com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution;

import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution.strategy.SportStrategy;

public class SportWithSDP extends VehicleWithSDP{
	
	
	public SportWithSDP() {
		super(new SportStrategy());
		// TODO Auto-generated constructor stub
	}

}
