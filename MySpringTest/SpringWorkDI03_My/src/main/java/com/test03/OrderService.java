package com.test03;

public interface OrderService {
    
	int getDiscountAmount(int id, int price);

    String order(int id, int price);
}

