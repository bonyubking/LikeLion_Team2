package work03

import work03.sec03.FixDiscountPolicy
import work03.sec03.MemoryMemberRepository
import work03.sec03.OrderServiceImpl

beans {
    memberRepository(MemoryMemberRepository)
    discountPolicy(FixDiscountPolicy)
    orderService(OrderServiceImpl, memberRepository, discountPolicy)
}