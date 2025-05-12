package com.workshop7.num06;

public class PlaneTest {

	public static void main(String[] args) {
		
		Plane[] planes = new Plane[2];
		
		planes[0] = new Airplane("L747",1000);
		planes[1] = new Cargoplane("C40",1000);
		
		for (Plane arr: planes) {
			System.out.println(arr);
		}
		
		for (Plane arr: planes) {
			arr.flight(100);
			System.out.println(arr);
		}
		
		for (Plane arr: planes) {
			arr.refuel(200);
			System.out.println(arr);
		}
		
	}

}
