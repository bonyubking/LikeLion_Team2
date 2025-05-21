package com.test01;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest01 {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext01.xml");
		GoodsDao dao = factory.getBean("test", GoodsDao.class);

		System.out.println("================= 전체 상품 목록 ===================");
		List<GoodsVo> all = dao.listGoods();
		for (GoodsVo res : all) {
			System.out.println(res);
		}
		
	}

}
