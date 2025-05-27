package com.test02;

public class RateDiscountPolicy implements DiscountPolicy {


    @Override
    public int getDiscountAmount(int price) {
        return (int) (price*0.1);
    }
}
