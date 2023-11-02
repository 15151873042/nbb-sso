package com.nbb.ssoserver.pojo;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;

    private String password;

    /**
     * 验证码二次校验的值
     */
    private String captchaVerification;
}
