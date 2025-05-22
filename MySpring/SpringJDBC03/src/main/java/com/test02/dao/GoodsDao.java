package com.test02.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("test")
public class GoodsDao {

  private final GoodsMapper goodsMapper;

  @Autowired
  public GoodsDao(GoodsMapper goodsMapper) {
    this.goodsMapper = goodsMapper;
  }

  // 2. 전체 출력
  public List<GoodsVo> listGoods() {
    return goodsMapper.selectAllGoods();
  }

  public GoodsVo selectOneGoods(String code) {
    return goodsMapper.selectOneGoods(code);
  }

  // 3. 상품 추가
  public int insertGoods(GoodsVo vo) {
    int res = goodsMapper.insertGoods(vo);
    return res;
  }

  // 4. 상품 수정
  public int updateGoods(GoodsVo vo) {
    int res = goodsMapper.updateGoods(vo);
    return res;
  }

  // 5. 상품 삭제
  public int deleteGoods(String code) {
    return goodsMapper.deleteGoods(code);
  }
}
