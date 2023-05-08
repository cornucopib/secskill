package com.cornucopib.secskill.user.dao;

import com.cornucopib.secskill.user.vo.UserVO;

/**
 * Dao demo.
 *
 * @author cornucopib
 * @since 2023/4/2
 */
public interface IUserDao {

    int deleteByPrimaryKey(Integer id);

    int insert(UserVO record);

    int insertSelective(UserVO record);

    UserVO selectByPrimaryKey(Integer id);

    UserVO selectByTelphone(String telphone);

    int updateByPrimaryKeySelective(UserVO record);

    int updateByPrimaryKey(UserVO record);
}
