package com.luckyBoy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 抽奖设置
 */
@Getter
@Setter
@ToString
public class Setting {

    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 每次抽奖人数
     */
    private Integer batchNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private User user;

    /**
     * 奖项
     */
    private List<Award> awards;

    /**
     * 成员
     */
    private List<Member> members;

}