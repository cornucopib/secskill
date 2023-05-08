package com.cornucopib.secskill.user.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登录信息VO.
 *
 * @author cornucopib
 * @since 2023/5/7
 */
@Data
public class LoginVO {

    @NotEmpty(message = "手机号码不能为空!")
    private String telphone;

    @NotEmpty(message = "密码不能为空!")
    private String password;


}
