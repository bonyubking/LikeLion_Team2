package work05.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimeoutService {

  @Transactional(timeout = 2)
  public void slowProcess() throws InterruptedException {
    Thread.sleep(5000); // 5초
  }
}
