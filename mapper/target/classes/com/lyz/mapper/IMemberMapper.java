package com.lyz.mapper;


import com.lyz.domain.Member;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

public interface IMemberMapper {

     public List<Member> findAll();

}
