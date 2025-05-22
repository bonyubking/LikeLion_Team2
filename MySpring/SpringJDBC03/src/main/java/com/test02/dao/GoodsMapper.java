package com.test02.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;

@Mapper
public interface GoodsMapper {

  @Insert("insert into goodsinfo(code, name, price, maker) values (#{code},#{name},#{price},#{maker})")
  int insertGoods(GoodsVo vo);

  @Results(id = "goodsResultMap", value = {
      @Result(property = "code", column = "code"),
      @Result(property = "name", column = "name"),
      @Result(property = "price", column = "price"),
      @Result(property = "maker", column = "maker")
  })
  @Select("select * from goodsinfo where code=#{code}")
  GoodsVo selectOneGoods(String code);

  @ResultMap("goodsResultMap")
  @Select("select * from goodsinfo")
  List<GoodsVo> selectAllGoods();

  @Update("update goodsinfo set code = #{code}, name=#{name}, price=#{price}, maker=#{maker}")
  int updateGoods(GoodsVo vo);

  @Delete("delete from goodsinfo where code=#{code}")
  int deleteGoods(String code);

}
