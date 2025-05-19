package com.sec01;


public class MyAddress {
    
    private String street;
    private String city;
    private String num;

    public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setNum(String num) {
		this.num = num;
	}

	// 기본 생성자
    public MyAddress() {
    	this("seoul", "street","hee");
    }
    
    public MyAddress(String street) {
    	this(street, "busan", "hee");
    }
    
    public MyAddress(String street, String city) {
    	
    	this(street,city,"hee");
    	
    }
    
    

    public MyAddress(String street, String city, String num) {
    	
		super();
		this.street = street;
		this.city = city;
		this.num = num;
	}


    @Override
    public String toString() {
        return "MyAddress [street=" + street + ", city=" + city + ", num =" + num +"]" ;
    }
}