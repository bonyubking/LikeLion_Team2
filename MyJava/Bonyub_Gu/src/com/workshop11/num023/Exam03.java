package com.workshop11.num023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Exam03 {
	


	public static void main(String[] args) throws IOException {
			
        	Path filePath = Path.of("./truck_status.txt"); 
		
			truck Truck = new truck(1000, 100.0, 5.0);
	        List<String> logs = new ArrayList<>();
	        List<Integer> distanceList = List.of(30,30,50);
			
	        Truck.SetOil(50.0);
			logs.add(Truck.toString());
			Truck.drive(50.0);
			logs.add(Truck.toString());
			Truck.SetWeight(100);
			logs.add(Truck.toString());
			Truck.drive(30.0);
			logs.add(Truck.toString());
			
			
			
			Files.writeString(filePath, String.join("\n", logs));
			
	        System.out.println("2번 문제 출력");
	        String fileContent = Files.readString(filePath);
	        System.out.println(fileContent);
	        
	        System.out.println("3번 문제 출력 ");
	        
	        logs.stream().forEach(System.out::println);
			
	        System.out.printf("총 요금 : %.1f원" , Truck.getCost());


	}

}
