package com.cornucopib.secskill.stock.dao;

import com.cornucopib.secskill.stock.dataobject.StockDO;
import org.apache.ibatis.annotations.Param;

/**
 * 库存dao
 *
 * @author cornucopib
 * @since 2023/5/10
 */
public interface IStockDao {

    int deleteByPrimaryKey(String id);

    int insert(StockDO record);

    int insertSelective(StockDO record);

    StockDO selectByPrimaryKey(String id);

    StockDO selectByItemId(String itemId);

    int decreaseStock(@Param("itemId") String itemId, @Param("amount") Integer amount);

    int updateByPrimaryKeySelective(StockDO record);

    int updateByPrimaryKey(StockDO record);
}
