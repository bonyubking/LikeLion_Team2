package com.test02;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountFixAmount = 1000; // 고정 할인 금액

    @Override
    public int getDiscountAmount(int price) {
        return discountFixAmount;
    }
}
