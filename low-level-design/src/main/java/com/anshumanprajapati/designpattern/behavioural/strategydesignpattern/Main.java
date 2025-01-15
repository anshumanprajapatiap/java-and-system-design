package com.anshumanprajapati.designpattern.behavioural.strategydesignpattern;

import java.util.*;

import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.problem.OffRoad;
import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.problem.Passanger;
import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.problem.Sport;
import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.problem.VehicleSDP;
import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution.OffRoadWithSDP;
import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution.PassangerWithSDP;
import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution.SportWithSDP;
import com.anshumanprajapati.designpattern.behavioural.strategydesignpattern.solution.VehicleWithSDP;


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
