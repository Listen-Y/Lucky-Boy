package com.luckyBoy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 奖项
 */
@Getter
@Setter
@ToString
public class Award {

    private Integer id;

    /**
     * 奖项名称
     */
    private String name;

    /**
     * 奖品数量
     */
    private Integer count;

    /**
     * 奖品
     */
    private String award;

    /**
     * 抽奖设置id
     */
    private Integer settingId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 获得此奖品的memberId
     */
    private List<Integer> luckyMemberIds;
}