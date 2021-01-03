package com.luckyBoy.model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * user的POJO对象
 * User: Listen-Y.
 * Date: 2021-01-02
 * Time: 12:24
 */
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;


@Getter
@Setter
@ToString
public class User{

    private Integer id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像url
     */
    private String head;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 抽奖环境ID
     */
    private Integer settingId;
}
