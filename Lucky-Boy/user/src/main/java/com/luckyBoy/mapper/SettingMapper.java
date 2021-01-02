package com.luckyBoy.mapper;


import com.luckyBoy.model.Setting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.luckyBoy.base.BaseMapper;

@Mapper
@Repository
public interface SettingMapper extends BaseMapper<Setting> {

    int updateByUserId(Integer id, Integer batchNumber);
}