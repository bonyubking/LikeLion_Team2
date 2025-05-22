package work05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {

  private AsyncMailService mailService;

  @Autowired
  public ReportService(AsyncMailService mailService) {
    this.mailService = mailService;
  }

  @Transactional
  public void completeReport() {
    mailService.sendMailSync();
  }
}