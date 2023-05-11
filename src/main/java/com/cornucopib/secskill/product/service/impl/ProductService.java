package com.cornucopib.secskill.product.service.impl;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.product.dao.IProductDao;
import com.cornucopib.secskill.product.dataobject.ProductDO;
import com.cornucopib.secskill.product.model.ProductModel;
import com.cornucopib.secskill.product.service.IProductService;
import com.cornucopib.secskill.stock.dao.IStockDao;
import com.cornucopib.secskill.stock.dataobject.StockDO;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品服务.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
public class ProductService implements IProductService {

    @Resource
    private IProductDao productDao;

    @Resource
    private IStockDao stockDao;

    @Override
    public ProductModel createItem(ProductModel productModel) throws ApiException {
        productModel.setId(System.currentTimeMillis()+"");

        ProductDO productDO=new ProductDO();
        BeanUtils.copyProperties(productModel,productDO);

        productDao.insertSelective(productDO);

        StockDO stockDO=getStock(productModel);
        stockDao.insertSelective(stockDO);

        return null;
    }

    private StockDO getStock(ProductModel productModel) {
        StockDO stockDO = new StockDO();
        stockDO.setStock(productModel.getStock());
        stockDO.setItemId(productModel.getId());
        return stockDO;
    }

    @Override
    public List<ProductModel> listItem() {
        return null;
    }

    @Override
    public ProductModel getItemById(Integer id) {
        return null;
    }

    @Override
    public boolean decreaseStock(Integer itemId, Integer amount) throws ApiException {
        return false;
    }

    @Override
    public void increaseSales(Integer itemId, Integer amount) throws ApiException {

    }
}
