package com.sec04;

import com.sec01.MyAddress;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyCollection {
  private List<String> items;
  private String[] myarray;
  private Set<String> myset;
  private Map<String, String> mymap;
  private Map<String, MyAddress> myaddr;

  public void setItems(List<String> items){
    this.items = items;
  }

  public void setMyarray(String[] items){
    this.myarray = items;
  }

  public void setMyset(Set<String> items){
    this.myset = items;
  }

  public void setMymap(Map<String, String> items){
    this.mymap = items;
  }
  public void setMyaddr(Map<String, MyAddress> items){
    this.myaddr = items;
  }

  public void printItems(){
    System.out.println("Items in List:");
    for(String item : items){
      System.out.println("- "+item);
    }
  }

  public void printArray(){
    System.out.println("Items in Array:");
    for(String item : myarray){
      System.out.println("- "+item);
    }
  }

  public void printSet(){
    System.out.println("Items in set:");
    for(String item : myset){
      System.out.println("- "+item);
    }
  }

  public void printMap(){
    System.out.println("Items in Map:");
    for(Map.Entry<String, String> entry : mymap.entrySet()){
      System.out.println(" -Key : "+entry.getKey()+" - Value : "+entry.getValue());
    }
  }

  public void printAddr(){
    System.out.println("Items in Address:");
    for(Map.Entry<String, MyAddress> entry : myaddr.entrySet()){
      System.out.println(" -Key : "+entry.getKey()+" - Value : "+entry.getValue());
    }

  }
}
