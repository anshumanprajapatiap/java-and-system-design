package designpattern.strategydesignpattern.solution;

import designpattern.strategydesignpattern.solution.strategy.DriveStrategy;

public class VehicleWithSDP {
	
	private DriveStrategy driveStrategyObject;
	
	public VehicleWithSDP(DriveStrategy strategy) {
		// TODO Auto-generated constructor stub
		this.driveStrategyObject = strategy;
	}
	
	public void drive() {
		driveStrategyObject.drive();
	}

}
