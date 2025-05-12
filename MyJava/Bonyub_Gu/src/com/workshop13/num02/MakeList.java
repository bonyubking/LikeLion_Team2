package com.workshop13.num02;

import java.util.ArrayList;
import java.util.Random;

public class MakeList {
	  
	private ArrayList<Integer> list;
	  
	
	 public MakeList() {
	
		list = new ArrayList<>();
	}
	 
	  public void makeArrayList(int size) {
		  
		  Random rand = new Random();
		  for (int i=0; i<size; i++) {
			  int ranNum = rand.nextInt(100);
			  list.add(ranNum);
		  }
	  }
	  
	  public double getAverage() {
		  
		  double sum = 0;
		  for (Integer num : list) {
			  sum += num;
		  }
		  
		  return sum / list.size();
		  
		  /* return list.stream()
		   * 		.mapToInt(Integer::intValue)
		   * 		.average()
		   * 		.orElse(0.0);
		   */
		  
	  }			
	  
	  	/*  Case 1 : Arrays;asList() reverse (List<?> list)
	  	 *  case 2 : Stream.Api reverse(List<?> list)
	  	 */
	    public ArrayList<Integer> getList() {
	        return list;
	    }
	  

}
