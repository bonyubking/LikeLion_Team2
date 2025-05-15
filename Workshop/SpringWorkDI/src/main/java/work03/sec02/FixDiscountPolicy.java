package work03.sec02;

public class FixDiscountPolicy implements DiscountPolicy {

  private static final int DISCOUNT_AMOUNT = 1000;

  @Override
  public int getDiscountAmount(int price) {
    return DISCOUNT_AMOUNT;
  }
}
