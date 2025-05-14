package com.sec04;

import java.util.List;
import java.util.Set;

public class MyCollection {
	
	private List<String> items;
	private String[] myarray;
	private Set<String> myset;
	
	public void setItems(List<String> items) {
		this.items=items;
	}
	public void setMyarray(String[] myarray) {
		this.myarray=myarray;
	}
	public void setMyset(Set<String> items) {
		this.myset=items;
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

}
