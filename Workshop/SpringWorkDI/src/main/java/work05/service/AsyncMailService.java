package work05.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncMailService {

  @Async // 비동기 -> 호출하는 스레드와는 별개로 다른 별도의 스레드에서 실행됨
  public void sendMailSync(){
    System.out.println("[비동기 메일 발송]");
  }

}
