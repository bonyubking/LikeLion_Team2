package com.test03;

import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // 우선순위로 먼저 호출됨 -> 같은 타입의 빈이 여러개 선언되었을때
// 만일 호출하는 컨트롤러에서 @Qualifier가 존재하면 Qualifier가 우선임
public interface GoodsService {
    List<GoodsVo> getAll();
    GoodsVo get(String code);
    void add(GoodsVo vo);
    void edit(GoodsVo vo);
    void delete(String name);
}
