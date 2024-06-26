package com.nbb.ssoserver.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer, SmartInitializingSingleton {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor(handler -> {

            SaRouter.match("/**")
                    .notMatch("/sso/doLogin") // 登录
                    .notMatch("/sso/createTicket") // 构建重定向地址，携带ticket参数
                    .notMatch("/sso/checkTicket") // 校验ticket
                    .notMatch("/sso/signout") // 单点注销
                    .notMatch("/sso/userInfo") // 获取登录用户信息
                    .notMatch("/captcha/**") // 验证码相关接口
                    .check(r -> StpUtil.checkLogin());

        })).addPathPatterns("/**");
    }


//    @Autowired
//    private SaTokenDaoRedisJackson saTokenDaoRedisJackson;
    @Override
    public void afterSingletonsInstantiated() {
//        // 取消对象json序列化时候，添加类信息，不然存入redis的类修改包名或类名，反序列化会报错
//        saTokenDaoRedisJackson.objectMapper.deactivateDefaultTyping();
    }
}
