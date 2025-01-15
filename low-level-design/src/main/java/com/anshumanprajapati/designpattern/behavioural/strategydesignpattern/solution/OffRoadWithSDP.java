package com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution;

import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution.strategy.SportStrategy;

public class OffRoadWithSDP extends VehicleWithSDP{

	public OffRoadWithSDP() {
		super(new SportStrategy());
		// TODO Auto-generated constructor stub
	}
	

}
