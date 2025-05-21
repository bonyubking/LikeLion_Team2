package work05.service;

import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class StockService {

  @Retryable(value = DeadlockLoserDataAccessException.class, maxAttempts = 3)
  public void updateStock() {
// 비즈니스 로직
  }
}