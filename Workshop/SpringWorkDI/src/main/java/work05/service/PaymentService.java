package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

  private final OrderRepository orderRepository;
  private final PaymentGateway paymentGateway;

  @Autowired
  public PaymentService(OrderRepository orderRepository, PaymentGateway paymentGateway) {
    this.orderRepository = orderRepository;
    this.paymentGateway = paymentGateway;
  }

  @Transactional
  public void processPayment(Order order){
    try {
      paymentGateway.send(order);
    } catch (ExternalServiceException e) {
      log.warn("결제 시스템 응답 실패");
    }
    orderRepository.save(order);
  }

}
