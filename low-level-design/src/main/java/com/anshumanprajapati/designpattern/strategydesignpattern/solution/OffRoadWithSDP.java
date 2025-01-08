package designpattern.strategydesignpattern.solution;

import designpattern.strategydesignpattern.solution.strategy.SportStrategy;

public class OffRoadWithSDP extends VehicleWithSDP{

	public OffRoadWithSDP() {
		super(new SportStrategy());
		// TODO Auto-generated constructor stub
	}
	

}
