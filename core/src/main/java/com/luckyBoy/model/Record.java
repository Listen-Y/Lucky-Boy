package com.luckyBoy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 获奖记录
 */
@Getter
@Setter
@ToString
public class Record{
    
    private Integer id;

    /**
     * 获奖人ID
     */
    private Integer memberId;

    /**
     * 奖品ID
     */
    private Integer awardId;

    /**
     * 创建时间
     */
    private Date createTime;
}