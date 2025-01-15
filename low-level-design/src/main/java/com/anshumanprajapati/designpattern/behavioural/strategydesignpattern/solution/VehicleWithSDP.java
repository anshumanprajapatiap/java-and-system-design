package com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution;

import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution.strategy.DriveStrategy;

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
