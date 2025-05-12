package com.workshop13.num04;

import java.util.ArrayList;
import java.util.List;

public class ShipTest {

	public static void main(String[] args) {
		
		List<Ship> shipList = new ArrayList<>();
		
		shipList.add(new Boat("Boat01", 500));
		shipList.add(new Cruise("Cruise01", 1000));
		
		System.out.println("------------------");
		for (Ship shp : shipList) {

			System.out.printf(shp.getShipName()+"      "+shp.getFuelTank());
			System.out.println();

		}
		System.out.println("------------------");
		
		for (Ship shp : shipList) {

            shp.sail(10); 
			System.out.printf(shp.getShipName()+"      "+shp.getFuelTank());
			System.out.println();

		}
		
		System.out.println("------------------");
		
		for (Ship shp : shipList) {
            shp.refuel(50); 
			System.out.printf(shp.getShipName()+"      "+shp.getFuelTank());
			System.out.println();

		}
		
		
	}

}
