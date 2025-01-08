package solid.lsp;

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		
		List<Vehicle> vehicleList = new ArrayList<>();

		vehicleList.add(new MoterCycle());
		vehicleList.add(new Car());
		vehicleList.add(new Bycycle());
		
		for(Vehicle v: vehicleList) {
			System.out.println(v.getNumberOfWheels()); // This is because vechicle class in not aware about hasEngine Method
		}
		

		List<EngineVehicle> EngineVehicleList = new ArrayList<>();

		EngineVehicleList.add(new MoterCycle());
		EngineVehicleList.add(new Car());
		
//		EngineVehicleList.add(new Bycycle()); 
		// this cannot be added as Bycycle is not child of EnginerVehicle Class
		
		
		for(Vehicle ev: EngineVehicleList) {
			System.out.println(((EngineVehicle) ev).getHasEngine());
		}
		
		
		
	}

}
