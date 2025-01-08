package designpattern.strategydesignpattern.solution;

import designpattern.strategydesignpattern.solution.strategy.SportStrategy;

public class SportWithSDP extends VehicleWithSDP{
	
	
	public SportWithSDP() {
		super(new SportStrategy());
		// TODO Auto-generated constructor stub
	}

}
