package com.luckyBoy.mapper;


import com.luckyBoy.base.BaseMapper;
import com.luckyBoy.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper extends BaseMapper<Member> {
}