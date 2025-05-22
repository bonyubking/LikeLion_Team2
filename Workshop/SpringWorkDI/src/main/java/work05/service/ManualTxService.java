package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class ManualTxService {

  //문제 8 정답 -> TransactionTemplate을 활용해서 수동 핸들링하는 작업
  @Autowired
  @Qualifier("transactionManager") // -> 의존성 모호할때 사용함
  private PlatformTransactionManager txManager;

  public void process() {

    TransactionTemplate template = new TransactionTemplate(txManager);
    template.execute(status -> {
      System.out.println("[트랜잭션 수동 처리]");
      status.setRollbackOnly(); // 롤백
      return null;
    });
  }
}
