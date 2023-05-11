package com.cornucopib.secskill.product.dao;

import com.cornucopib.secskill.product.dataobject.ProductDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品dao.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
public interface IProductDao {

    List<ProductDO> listItem();

    int deleteByPrimaryKey(String id);

    int insert(ProductDO record);

    int insertSelective(ProductDO record);

    ProductDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductDO record);

    int updateByPrimaryKey(ProductDO record);

    int increaseSales(@Param("id")String id, @Param("amount")Integer amount);
}
