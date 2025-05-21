package com.test02.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test01.GoodsVo;

public class GoodsDao implements GoodsMapper {

	// 2. 전체 출력
	public List<GoodsVo> listGoods() {
		try (SqlSession session = factory.openSession()) {
			return session.selectList("mybatis.goodMapper.listgoods");
		}
	}

//3.상품 추가
	public int insertGoods(GoodsVo vo) {
		try (SqlSession session = factory.openSession()){
			int res=session.insert("mybatis.goodMapper.insertgoods",vo);
			if (res>0) session.commit();
			else session.rollback();
			return res;
		}
	}

	// 4. 상품 정보 수정
	public int updateGoods(GoodsVo vo) {
		try (SqlSession session = factory.openSession()){
			int res=session.update("mybatis.goodMapper.updategoods",vo);
			if (res>0) session.commit();
			else session.rollback();
			return res;
		}
	}

	// 5. 상품 삭제
	public int deleteGoods(String name) {
		try (SqlSession session = factory.openSession()){
			int res=session.delete("mybatis.goodMapper.deletegoods",name);
			if (res>0) session.commit();
			else session.rollback();
			return res;
		}
	}
	//6. 상품 조회(코드 기준)
	public GoodsVo findDoods(String code) {
		try (SqlSession session = factory.openSession()){
			return session.selectOne("mybatis.goodMapper.deletegoods",code);
		}
	}
}
