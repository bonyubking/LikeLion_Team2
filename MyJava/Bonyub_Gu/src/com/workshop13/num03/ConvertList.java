package com.workshop13.num03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertList {
	
	public ArrayList<Integer> convertList(int[] array){
		
        List<Integer> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
        
       Collections.reverse(list);
       
       return new ArrayList<>(list);
		
	}

}
