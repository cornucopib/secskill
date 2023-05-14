package com.cornucopib.secskill.product.service;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.product.model.ProductModel;

import java.util.List;

/**
 * 商品服务类.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
public interface IProductService {


    //创建商品
    ProductModel createItem(ProductModel ProductModel) throws ApiException;

    //商品列表浏览
    List<ProductModel> listItem();

    //商品详情浏览
    ProductModel getProductById(String id);

    //库存扣减
    boolean decreaseStock(String itemId,Integer amount)throws ApiException;

    //商品销量增加
    void increaseSales(String itemId,Integer amount)throws ApiException;
}
