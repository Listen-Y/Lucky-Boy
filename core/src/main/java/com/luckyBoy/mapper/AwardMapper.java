package com.luckyBoy.mapper;

import com.luckyBoy.base.BaseMapper;
import com.luckyBoy.model.Award;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface AwardMapper extends BaseMapper<Award> {
    List<Award> query(Award award);
}