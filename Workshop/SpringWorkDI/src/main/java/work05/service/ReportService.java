package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {

  @Autowired
  private AsyncMailService mailService;

  @Transactional
  public void completeReport() {
    mailService.sendMailSync();
  }
}