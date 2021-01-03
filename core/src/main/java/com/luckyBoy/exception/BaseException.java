package com.luckyBoy.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 自定义异常的父类 用于项目中异常处理
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 10:06
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

    private String code;

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
