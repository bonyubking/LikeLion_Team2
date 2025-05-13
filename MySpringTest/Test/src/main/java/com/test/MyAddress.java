package main.java.com.test;

public class MyAddress {
    
    private String street;
    private String city;

    // 기본 생성자
    public MyAddress() {
        this.street = "Seoul Street";
        this.city = "Seoul";
    }

    // getter / setter
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return "MyAddress [street=" + street + ", city=" + city + "]";
    }
}