
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    // 문제10 정답
    @Transactional
    //@Retryable : DEADLockloserdataaccessException 발생하면 재시도 하는 트랙잭션
    //@Deprecated(since="6.0.3")
    public void updateStock() {
        System.out.println("[재고 업데이트 실행]");
        // 재시도 처리 예시
    }
}
