package com.cornucopib.secskill.user.controller;

import com.cornucopib.secskill.common.api.controller.BaseController;
import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.result.CommonResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 用户controller
 *
 * @author cornucopib
 * @since 2023/4/9
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @GetMapping("/getVerificationCode")
    public CommonResult<?> getVerificationCode() throws ApiException {
        return CommonResult.success("12345");
    }

    @PostMapping("/register")
    public CommonResult<?> register() throws ApiException {
        return CommonResult.success(null);
    }

    @PostMapping("/login")
    public CommonResult<?> login() throws ApiException {
        return CommonResult.success("x12304");
    }

}
