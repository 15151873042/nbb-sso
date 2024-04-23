package com.nbb.ssoserver;


import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SSoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SSoServerApplication.class, args);
        log.info("Sa-Token配置如下：{}", SaManager.getConfig());
    }
}
