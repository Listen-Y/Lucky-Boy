package com.luckyBoy.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 业务端异常
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 13:10
 */
@Getter
@Setter
public class BusinessException extends BaseException {


    public BusinessException(String code, String message) {
        super("BUS" + code, message);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super("BUS" + code, message, cause);
    }
}
