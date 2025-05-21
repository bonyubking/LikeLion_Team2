package com.sec04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sec01.MyAddress;

@Configuration
public class App {

	@Bean
	public MyAddress m01() {
		return new MyAddress("신길동","sea","1234");
	}
	@Bean
	public MyAddress m02() {
		return new MyAddress("백길동","sky","5678");
	}
	
	@Bean
	public MyCollection myCollection() {
		MyCollection m = new MyCollection();
		m.setItems(Arrays.asList("AA","BB","CC"));
		m.setMyarray(new String[] {"H","E","L","L","O"});
		m.setMyset(Set.of("N","A","M","E"));
		m.setMymap(Map.of("B","BB","R","RR","O","O"));
		
		Map<String, MyAddress> U_map=new HashMap<>();
		U_map.put("All", m01());
		U_map.put("B11", m02());
		m.setMyaddr(U_map);
		return m;
	}
}
