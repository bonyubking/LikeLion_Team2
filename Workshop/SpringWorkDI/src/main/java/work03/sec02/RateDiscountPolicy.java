package work03.sec02;

public class RateDiscountPolicy implements DiscountPolicy {
  private static final double DISCOUNT_RATE = 0.1;

  @Override
  public int getDiscountAmount(int price) {
    return (int) (price * DISCOUNT_RATE);
  }
}
