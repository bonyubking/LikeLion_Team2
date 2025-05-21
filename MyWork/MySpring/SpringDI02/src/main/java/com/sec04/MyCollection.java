package com.sec04;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import com.sec01.MyAddress;

public class MyCollection {
	
	private List<String> items;
	private String[] myarray;
	private Set<String> myset;
	public Map<String,String> mymap;
	public Map<String,MyAddress> myaddr;

	
	public void setItems(List<String> items) {
		this.items=items;
	}
	public void setMyarray(String[] myarray) {
		this.myarray=myarray;
	}
	public void setMyset(Set<String> items) {
		this.myset=items;
	}
	public void setMymap(Map<String,String> item){
		this.mymap=item;
	}
	public void setMyaddr(Map<String, MyAddress> item) {
		this.myaddr=item;
	}
	
	public void printItems() {
		System.out.println("Items in List :");
		for(String item : items) {
			System.out.println("-" + item);
		}
	}
	
	public void printArray() {
		System.out.println("Items in Array :");
		for(String item : myarray) {
			System.out.println("-" + item);
		}
	}
	
	public void printSet() {
		System.out.println("Items in set :");
		for(String item : myset) {
			System.out.println("-" + item);
		}
	}
	
	public void printMap() {
		for(Map.Entry<String,String> entry : mymap.entrySet()) {
			System.out.println("-KEY : " +entry.getKey()+ " -Value : "+entry.getValue());
		}
	}
	
	public void printMyaddr() {
		for(Entry<String, MyAddress> entry : myaddr.entrySet()) {
			System.out.println("-KEY : " +entry.getKey()+ " -Value : "+entry.getValue());
		}
	}

}
