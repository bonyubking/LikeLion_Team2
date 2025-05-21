package work05.service;

import com.google.protobuf.CodedOutputStream.OutOfSpaceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  @Transactional(rollbackFor = OutOfSpaceException.class)
  public void orderItem(Long itemId) throws OutOfSpaceException {
    if (!inStock(itemId)) throw new OutOfSpaceException();
  }

  private boolean inStock(Long itemId) {
    return false;
  }
}
