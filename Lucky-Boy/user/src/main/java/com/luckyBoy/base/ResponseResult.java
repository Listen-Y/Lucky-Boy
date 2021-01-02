package com.luckyBoy.base;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * 返回数据的统一包装类型
 * User: Listen-Y.
 * Date: 2021-01-02
 * Time: 12:23
 */
@Getter
@Setter
public class ResponseResult {

    private boolean success;
    private Object data;
    private String code;
    private String message;


    public ResponseResult() {
    }

    public static ResponseResult ok(Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.data = data;
        responseResult.success = true;
        return responseResult;
    }

    public static ResponseResult error(String code, String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.success = false;
        responseResult.code = code;
        responseResult.message = message;
        return responseResult;
    }

    public static ResponseResult error() {
        return error("ERR000", "未知错误");
    }

}
