package com.cornucopib.secskill.order.dao;

import com.cornucopib.secskill.order.dataobject.OrderDO;

/**
 * 订单dao.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
public interface IOrderDao {

    int deleteByPrimaryKey(String id);

    int insert(OrderDO record);

    int insertSelective(OrderDO record);

    OrderDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderDO record);
    int updateByPrimaryKey(OrderDO record);

}
