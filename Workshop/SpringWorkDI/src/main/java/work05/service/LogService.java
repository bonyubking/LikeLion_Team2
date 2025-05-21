package work05.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void saveLog(String msg) {
    // 로그 저장
  }
}
