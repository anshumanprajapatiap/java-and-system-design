package designpattern.strategydesignpattern.solution;

import designpattern.strategydesignpattern.solution.strategy.NormalStrategy;

public class PassangerWithSDP extends VehicleWithSDP{
	
	
	public PassangerWithSDP() {
		super(new NormalStrategy());
		// TODO Auto-generated constructor stub
	}

}
