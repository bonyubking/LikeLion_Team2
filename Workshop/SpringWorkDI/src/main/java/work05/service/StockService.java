package work05.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

  @Transactional
  public void updateStock() {
    // 재시도 처리 예시
  }
}