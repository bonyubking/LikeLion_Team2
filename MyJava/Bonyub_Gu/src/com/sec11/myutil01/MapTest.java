package com.sec11.myutil01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {

		Map<String, String> hm = new HashMap<>();

		hm.put("name", "밀로");
		hm.put("addr", "Toronto");
		hm.put("tel", "02-000-000");

		System.out.println("전체출력 : " + hm);

		System.out.println("\n  entrySet()을 이용한 View");
		
		// Set<Map.Entry<K,V>> entrySet() 키는 키대로, 밸류는 밸류대로 관리
		Set<Entry<String, String>> entires = hm.entrySet();

		for (Entry<String, String> ent : entires) {
			System.out.println(ent.getKey() + " ==> " + ent.getValue());
			
		}

		///////////////////////////////////////////////////////////////
		
		System.out.println("\n  keySet()을 이용한 View");
		Set<String> keys = hm.keySet();

		for (String key : keys) {
			System.out.println("Value of " + key + " is: " + hm.get(key));
		}

		System.out.println("\n  values()을 이용한 View");
		Collection<String> con = hm.values();
		for (String value : con) {
			System.out.println("Value is :" + value);
		}

		System.out.println("\n  키와 값을 찾아 값을 변경 ");
		if (hm.containsKey("name") && hm.containsValue("밀로")) {
			hm.replace("name", "루리");
		}

		System.out.println(hm);
	}

}
