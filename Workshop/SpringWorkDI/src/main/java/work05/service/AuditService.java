package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("auditTransactionManager")
public class AuditService {

  @Autowired
  private AuditRepository auditRepo;

  public void saveAudit(AuditLog log) {
    auditRepo.save(log);
  }
}
