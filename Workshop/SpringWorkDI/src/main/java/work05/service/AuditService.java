package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work05.domain.AuditLog;
import work05.repository.AuditRepository;

@Service
public class AuditService {

  private final AuditRepository auditRepo;

  @Autowired
  public AuditService(AuditRepository auditRepo) {
    this.auditRepo = auditRepo;
  }

  @Transactional(transactionManager = "auditTxManager")
  public void saveAudit(AuditLog log) {
    auditRepo.save(log);
  }
}
