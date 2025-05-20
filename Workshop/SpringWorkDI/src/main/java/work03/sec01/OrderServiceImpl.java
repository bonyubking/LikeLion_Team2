package work03.sec01;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public String order(int id, int price) { // 비즈니스 로직 설계 : 회원이름 조회, 할인 금액 계산, 최종결제금액 계산
    String memberName = memberRepository.findMemberById(id);
    int discountAmount = discountPolicy.getDiscountAmount(price);
    int discountPrice = price - discountAmount;
    return "회원: "+memberName+"\n주문 금액: "+price+" 원\n할인 금액: "+discountAmount+" 원\n최종 결제 금액: "+discountPrice+" 원";
  }
}
