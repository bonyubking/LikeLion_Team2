package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class ManualTxService {

  @Autowired
  private PlatformTransactionManager txManager;

  public void process() {
    TransactionTemplate template = new TransactionTemplate(txManager);
    template.execute(status -> {
      status.setRollbackOnly(); // 롤백
      return null;
    });
  }
}
