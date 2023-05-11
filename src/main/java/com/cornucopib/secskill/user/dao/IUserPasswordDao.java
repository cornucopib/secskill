package com.cornucopib.secskill.user.dao;

import com.cornucopib.secskill.user.vo.UserPasswordVO;

/**
 * Dao demo.
 *
 * @author cornucopib
 * @since 2023/4/2
 */
public interface IUserPasswordDao {

    int deleteByPrimaryKey(Integer id);

    int insert(UserPasswordVO record);

    int insertSelective(UserPasswordVO record);

    UserPasswordVO selectByPrimaryKey(Integer id);

    UserPasswordVO selectByTelphone(String telphone);

    int updateByPrimaryKeySelective(UserPasswordVO record);

    int updateByPrimaryKey(UserPasswordVO record);

    UserPasswordVO selectByUserId(String userId);
}
