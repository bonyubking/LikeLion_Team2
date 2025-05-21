package com.test01;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

/*
 * MyBatis 기반 GoodsInfo Dao 클래스
 * SqlSessionFactory 초기화
 * Mapper xml 호출을 사용한 CRUD 실행 
 */
@Component("test")
public class GoodsDao {
	// 1. SqlSessionFactory 초기화
	private static SqlSessionFactory factory;
	static {
		try {
			String resuorce = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resuorce);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}// static end
		
	// 2. 전체출력 mybatis.goodsMapper.listgoods
	public List<GoodsVo> listGoods() {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("org.mybatis.example.BlogMapper.listgoods");
		}
	}
}// class end
