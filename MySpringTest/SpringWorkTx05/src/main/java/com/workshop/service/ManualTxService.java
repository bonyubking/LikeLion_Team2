
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class ManualTxService {

	// 문제8 정답 -> TransactionTemplate를 활용해서 수동 핸들링
    @Autowired
    @Qualifier("transactionManager") // -> 의존성 주입할떄 모호한 에외 -> 명시해주는 기능
    private PlatformTransactionManager txManager;

    public void process() {
    	//doInTransaction(TransactionStatus status)
        TransactionTemplate template = new TransactionTemplate(txManager);
        template.execute(status -> {
            // 문제8 정답
            System.out.println("[트랜잭션 수동 처리]");
            status.setRollbackOnly();
            return null;
        });
    }
}
