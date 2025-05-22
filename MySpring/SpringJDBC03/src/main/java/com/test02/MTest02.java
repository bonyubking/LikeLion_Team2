package com.test02;

import com.test02.dao.GoodsDao;
import com.test02.dao.GoodsVo;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest02 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext02.xml");
    GoodsDao goodsDao = context.getBean("test", GoodsDao.class);

    System.out.println("================전체 상품 목록================");
    List<GoodsVo> all = goodsDao.listGoods();
    for (GoodsVo goodsVo : all) {
      System.out.println(goodsVo);
    }

    System.out.println("================vo01 추가 후 전체 목록================");
    GoodsVo vo = context.getBean("vo01", GoodsVo.class);
    goodsDao.insertGoods(vo);
    all = goodsDao.listGoods();
    for (GoodsVo goodsVo : all) {
      System.out.println(goodsVo);
    }

    System.out.println("================code 삭제 후 전체 목록================");
    String code = context.getBean("code01", String.class);
    goodsDao.deleteGoods(code);
    all = goodsDao.listGoods();
    for (GoodsVo goodsVo : all) {
      System.out.println(goodsVo);
    }
  }
}
