package designpattern.strategydesignpattern;

import java.util.*;

import designpattern.strategydesignpattern.problem.OffRoad;
import designpattern.strategydesignpattern.problem.Passanger;
import designpattern.strategydesignpattern.problem.Sport;
import designpattern.strategydesignpattern.problem.VehicleSDP;
import designpattern.strategydesignpattern.solution.OffRoadWithSDP;
import designpattern.strategydesignpattern.solution.PassangerWithSDP;
import designpattern.strategydesignpattern.solution.SportWithSDP;
import designpattern.strategydesignpattern.solution.VehicleWithSDP;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<VehicleSDP> vehcileList = new ArrayList<>();
		
		vehcileList.add(new Sport());
		vehcileList.add(new Passanger());
		vehcileList.add(new OffRoad());
		
		
		for(VehicleSDP v:vehcileList) {
			v.drive();
		}
		


		List<VehicleWithSDP> vehcileListWithSDP = new ArrayList<>();
		
		vehcileListWithSDP.add(new SportWithSDP());
		vehcileListWithSDP.add(new PassangerWithSDP());
		vehcileListWithSDP.add(new OffRoadWithSDP());
		
		
		for(VehicleSDP v:vehcileList) {
			v.drive();
		}

	}

}
