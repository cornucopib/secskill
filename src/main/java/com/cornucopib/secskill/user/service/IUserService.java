package com.cornucopib.secskill.user.service;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.user.vo.LoginVO;
import com.cornucopib.secskill.user.vo.UserVO;

/**
 * 用户服务接口类.
 *
 * @author cornucopib
 * @since 2023/4/3
 */
public interface IUserService {

    /**
     * 注册
     *
     * @param userVO 注册的用户信息
     * @throws ApiException 异常
     */
    void register(UserVO userVO) throws ApiException;

    /**
     * 登录
     * @param loginVO 登录信息vo
     * @return 用户信息
     * @throws ApiException 异常
     */
    UserVO login(LoginVO loginVO) throws  ApiException;

}
