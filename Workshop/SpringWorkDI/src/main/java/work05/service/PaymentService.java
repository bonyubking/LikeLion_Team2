package work05.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work05.domain.Order;

@Service
public class PaymentService {
  @Transactional // 외부 시스템 실패 시 무시하고 DB 처리는 계속 하도록 설계
  public void processPayment(Order order){
    try {
      System.out.println("외부 결제 처리 중...");
      throw new RuntimeException("결제 실패");
    } catch (Exception e) {
      System.out.println("예외 발생 -> 무시하고 DB 저장 진행");
    }
    System.out.println("DB 저장 완료");
  }
}
