package com.lyz.mapper;


import com.lyz.domain.Member;
import com.lyz.domain.response.MemberRank;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface IMemberMapper {

     //查询所有
     @Select("select * from member")
     @Results(id = "memberResultMap",value = {
      @Result(id = true,property = "id",column = "id"),
      @Result(property = "username",column = "username"),
      @Result(property = "sex",column = "sex"),
      @Result(property = "phoneNumber",column = "phone_number"),
      @Result(property = "email",column = "email"),
      @Result(property = "address",column = "address"),
      @Result(property = "status",column = "status"),
      @Result(property = "createDate",column = "create_date"),
      @Result(property = "updateDate",column = "update_date"),
      @Result(property = "rank",column = "member_rank",one = @One(select = ("com.lyz.mapper.IRankMapper.findById")))
     })
     public List<MemberRank> findAll();

     //更新
      @Update("update member set username=#{username}," +
              "sex=#{sex},phone_number=#{phoneNumber}," +
              "email=#{email},address=#{address},status=#{status},create_date=#{createDate},update_date=#{updateDate}," +
              "update_date=#{updateDate},member_rank=#{memberRank} where id=#{id}")
     public void update(Member member);

      //根据ID查询用户
      @Select("select * from member where id=#{id}")
      @Results(id = "memberResult",value = {
              @Result(id = true, property = "id", column = "id"),
              @Result(property = "username", column = "username"),
              @Result(property = "sex", column = "sex"),
              @Result(property = "phoneNumber", column = "phone_number"),
              @Result(property = "email", column = "email"),
              @Result(property = "address", column = "address"),
              @Result(property = "status", column = "status"),
              @Result(property = "createDate", column = "create_date"),
              @Result(property = "updateDate", column = "update_date"),
              @Result(property = "memberRank", column = "member_rank")
      })
     public Member findById(Integer id);

}
