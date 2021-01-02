package com.luckyBoy.mapper;


import com.luckyBoy.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.luckyBoy.model.Record;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper extends BaseMapper<Record> {


    int batchAdd(@Param("awardId") Integer awardId, @Param("memberIds") List<Integer> memberIds);

    void deleteByCondition(Record record);

    int deleteBySettingId(Integer id);
}