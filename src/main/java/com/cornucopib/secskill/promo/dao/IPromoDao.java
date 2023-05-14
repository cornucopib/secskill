package com.cornucopib.secskill.promo.dao;

import com.cornucopib.secskill.promo.dataobject.PromoDO;

/**
 * 秒杀dao.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
public interface IPromoDao {

    int deleteByPrimaryKey(String id);

    int insert(PromoDO record);

    int insertSelective(PromoDO record);

    PromoDO selectByPrimaryKey(String id);

    PromoDO selectByItemId(String itemId);

    int updateByPrimaryKeySelective(PromoDO record);

    int updateByPrimaryKey(PromoDO record);
}
