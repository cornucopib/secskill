package com.cornucopib.secskill.user.controller;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.result.CommonResult;
import com.cornucopib.secskill.user.service.impl.UserService;
import com.cornucopib.secskill.user.vo.LoginVO;
import com.cornucopib.secskill.user.vo.UserVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * 用户controller
 *
 * @author cornucopib
 * @since 2023/4/9
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private HttpServletRequest httpServletRequest;

    @Resource
    private UserService userService;

    @GetMapping("/getVerificationCode")
    public CommonResult<?> getVerificationCode(@RequestParam(name = "telphone") String telphone) throws ApiException {
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

        httpServletRequest.getSession().setAttribute(telphone, otpCode);
        return CommonResult.success(otpCode);
    }

    @PostMapping("/register")
    public CommonResult<?> register(@Validated @RequestBody UserVO userVO) throws ApiException {
        userService.register(userVO);
        return CommonResult.success(null);
    }

    @PostMapping("/login")
    public CommonResult<?> login(@Validated @RequestBody LoginVO loginVO) throws ApiException {
        userService.login(loginVO);
        return CommonResult.success("");
    }

}
