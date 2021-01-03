package com.luckyBoy.config.mvc;

import com.luckyBoy.base.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * controller返回数据统一处理
 * User: Listen-Y.
 * Date: 2021-01-03
 * Time: 11:02
 */
public class RequestResponseReturnValue implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler target;

    public RequestResponseReturnValue(HandlerMethodReturnValueHandler target) {
        this.target = target;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return target.supportsReturnType(methodParameter);
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest) throws Exception {

        //o是Controller请求方法执行完，返回值
        if (!(o instanceof ResponseResult)) {//返回值不是需要的类型，进行处理
            o = ResponseResult.ok(o);
        }
        target.handleReturnValue(o, methodParameter, modelAndViewContainer, nativeWebRequest);

    }
}
