package work05.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

  public void outer(){
    inner();
  }

  @Transactional
  public void inner(){
    throw new RuntimeException("에러");
  }
}
