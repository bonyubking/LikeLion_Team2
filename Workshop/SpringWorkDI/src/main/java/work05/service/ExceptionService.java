package work05.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExceptionService {

  @Transactional(rollbackFor = IOException.class)
  public void test() throws IOException {
    throw new IOException();
  }
}