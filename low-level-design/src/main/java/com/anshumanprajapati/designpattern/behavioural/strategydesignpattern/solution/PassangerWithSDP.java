package com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution;

import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution.strategy.NormalStrategy;

public class PassangerWithSDP extends VehicleWithSDP{
	
	
	public PassangerWithSDP() {
		super(new NormalStrategy());
		// TODO Auto-generated constructor stub
	}

}
