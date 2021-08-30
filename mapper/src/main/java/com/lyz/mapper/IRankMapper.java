package com.lyz.mapper;


import com.lyz.domain.Rank;
import org.apache.ibatis.annotations.Select;

public interface IRankMapper {

   @Select("select * from rank where id = #{id}")
   public Rank findById(Integer id);

}
