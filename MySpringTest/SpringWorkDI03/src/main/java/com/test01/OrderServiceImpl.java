package com.test01;

public class OrderServiceImpl implements OrderService {
    
	private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository,
                            DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public int getDiscountAmount(int id, int price) {
        return discountPolicy.getDiscountAmount(price);
    }

    @Override
    public String order(int id, int price) {
        String memberName = memberRepository.findMemberById(id);
        int discount = discountPolicy.getDiscountAmount(price);
        int finalPrice = price - discount;
        
        return String.format(
                "회원: %s  주문 금액: %d원, 할인 금액: %d원, 최종 결제 금액: %d원",
                memberName, price, discount, finalPrice);
    }
}

