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
		return new MyAddress("홍길도", "123123", "111");
	}
	
	@Bean
	public MyAddress m02() {
		return new MyAddress("정길도", "12333123", "111222");
	}
	
	@Bean
	public MyCollection myCollection() {
		
		MyCollection m = new MyCollection();
		m.setItems(Arrays.asList("AA", "BB", "CC", "DD"));
		m.setMyarray(new String[] {"Arr A", "Arr B", "Arr C", "Arr D"});
		m.setMyset(Set.of("Set A ", "Set B", "Set C","Set D"));
		m.setMymap(Map.of("Key A", "Map A ", "Key B", "Map B", "Key C", "Map C", "Key D", "Map D"));
		
		Map<String, MyAddress> U_map = new HashMap<>();
		U_map.put("A1", m01());
		U_map.put("B1", m02());
		
		m.setMyaddr(U_map);
		
		return m;
	}

}
