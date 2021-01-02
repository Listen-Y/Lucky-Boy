package com.luckyBoy.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 客户端异常
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 13:13
 */
@Getter
@Setter
public class ClientException extends BaseException {
    public ClientException(String code, String message) {
        super("CLI" + code, message);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI" + code, message, cause);
    }
}
