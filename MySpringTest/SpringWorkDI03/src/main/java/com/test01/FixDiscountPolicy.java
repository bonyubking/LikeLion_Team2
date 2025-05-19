package com.test01;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountFixAmount = 1000;

    @Override
    public int getDiscountAmount(int price) {
        return discountFixAmount;
    }
}
