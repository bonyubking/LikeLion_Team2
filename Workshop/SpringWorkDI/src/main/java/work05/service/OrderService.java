package work05.service;

import com.google.protobuf.CodedOutputStream.OutOfSpaceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

class OutOfStockException extends Exception {
  public OutOfStockException(String message) {
    super(message);
  }
}

@Service
public class OrderService {

  @Transactional(rollbackFor = OutOfStockException.class)
  public void orderItem(Long itemId) throws OutOfStockException {
    if (!inStock(itemId)) throw new OutOfStockException("재고 부족 예외 발생");
  }

  private boolean inStock(Long itemId) {
    return false;
  }
}
