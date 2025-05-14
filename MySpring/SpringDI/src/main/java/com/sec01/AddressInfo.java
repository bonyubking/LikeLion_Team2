package com.sec01;

public class AddressInfo {
  private MyAddress myAddress;
  private int age;

  public void setMyAddress(MyAddress myAddress) {
    this.myAddress = myAddress;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public void prn(){
    System.out.println(myAddress.toString());
    System.out.println(age);
  }
}
