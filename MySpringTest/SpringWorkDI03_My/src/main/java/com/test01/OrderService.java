package com.test01;

public interface OrderService {
    
	int getDiscountAmount(int id, int price);

    String order(int id, int price);
}

