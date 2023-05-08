package com.cornucopib.secskill.user.service.impl;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.exception.Asserts;
import com.cornucopib.secskill.common.api.status.impl.ApiStatus;
import com.cornucopib.secskill.user.dao.IUserDao;
import com.cornucopib.secskill.user.dao.IUserPasswordDao;
import com.cornucopib.secskill.user.service.IUserService;
import com.cornucopib.secskill.user.vo.LoginVO;
import com.cornucopib.secskill.user.vo.UserPasswordVO;
import com.cornucopib.secskill.user.vo.UserVO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户服务接口实现类.
 *
 * @author cornucopib
 * @since 2023/4/3
 */
@Service
public class UserService implements IUserService {

    @Resource
    private IUserDao userDao;

    @Resource
    private IUserPasswordDao userPasswordDao;

    @Override
    @Transactional
    public void register(UserVO userVO) throws ApiException {
        try {
            userDao.insertSelective(userVO);
        } catch (DuplicateKeyException e) {
            Asserts.fail(ApiStatus.RE_REGISTER_ERROR);
        }
        UserPasswordVO userPasswordVO = getUserPassword(userVO);
        userPasswordDao.insertSelective(userPasswordVO);
    }

    private UserPasswordVO getUserPassword(UserVO userVO) {
        UserPasswordVO userPasswordVO = new UserPasswordVO();
        userPasswordVO.setEncrptPassword(userVO.getEncrptPassword());
        userPasswordVO.setUserId(userVO.getId());
        return userPasswordVO;
    }

    @Override
    public UserVO login(LoginVO loginVO) throws ApiException {
        UserVO userVO = userDao.selectByTelphone(loginVO.getTelphone());
        if (userVO == null) {
            Asserts.fail(ApiStatus.LOGIN_ERROR);
        }
        UserPasswordVO userPasswordVO = userPasswordDao.selectByUserId(userVO.getId());
        if(!loginVO.getPassword().equals(userPasswordVO.getEncrptPassword())){
            Asserts.fail(ApiStatus.LOGIN_ERROR);
        }
        return userVO;
    }
}
