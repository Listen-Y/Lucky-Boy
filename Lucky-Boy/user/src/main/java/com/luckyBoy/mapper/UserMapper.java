package com.luckyBoy.mapper;

import com.luckyBoy.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.luckyBoy.base.BaseMapper;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}