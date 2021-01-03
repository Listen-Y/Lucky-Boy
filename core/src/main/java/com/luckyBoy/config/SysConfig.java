package com.luckyBoy.config;

import com.luckyBoy.config.mvc.LoginInterceptor;
import com.luckyBoy.config.mvc.RequestResponseReturnValue;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * MVC自定义配置
 * User: Listen-Y.
 * Date: 2021-01-03
 * Time: 11:24
 */
@Configuration
public class SysConfig implements WebMvcConfigurer, InitializingBean {

    @Resource
    private RequestMappingHandlerAdapter adapter;

    //SpringMVC初始化操作时，就会注册的对象
    //之前以@ControllerAdvice+ResponseBodyAdvice接口实现，完成统一处理返回数据包装：无法解决返回值为null需要包装
    //改用现在这种方式，可以解决返回null包装为自定义类型
    @Override
    public void afterPropertiesSet() {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(returnValueHandlers);

        for (int i = 0; i < handlers.size(); i++) {
            HandlerMethodReturnValueHandler handler = handlers.get(i);
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                handlers.set(i, new RequestResponseReturnValue(handler));
            }
        }
        adapter.setReturnValueHandlers(handlers);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**")//**代表多级任意匹配，*代表一级路径匹配
                .excludePathPatterns("/api/user/login")
                .excludePathPatterns("/api/user/register")
                .excludePathPatterns("/api/user/logout");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //Controller路径，统一添加请求的路径前缀，第二个参数，表示是否添加
        //所有Controller请求路径，都要带/api的前缀
        configurer.addPathPrefix("api", c -> true);
    }
}
