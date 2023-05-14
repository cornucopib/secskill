package com.cornucopib.secskill.product.service.impl;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.product.dao.IProductDao;
import com.cornucopib.secskill.product.dataobject.ProductDO;
import com.cornucopib.secskill.product.model.ProductModel;
import com.cornucopib.secskill.product.service.IProductService;
import com.cornucopib.secskill.promo.dao.IPromoDao;
import com.cornucopib.secskill.promo.model.PromoModel;
import com.cornucopib.secskill.promo.service.IPromoService;
import com.cornucopib.secskill.stock.dao.IStockDao;
import com.cornucopib.secskill.stock.dataobject.StockDO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品服务.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
@Service
public class ProductService implements IProductService {

    @Resource
    private IProductDao productDao;

    @Resource
    private IStockDao stockDao;

    @Resource
    private IPromoService promoService;

    @Override
    public ProductModel createItem(ProductModel productModel) throws ApiException {
        productModel.setId(String.valueOf(System.currentTimeMillis()));

        ProductDO productDO = new ProductDO();
        BeanUtils.copyProperties(productModel, productDO);

        productDao.insertSelective(productDO);

        StockDO stockDO = getStock(productModel);
        stockDao.insertSelective(stockDO);

        return getProductById(productModel.getId());
    }


    @Override
    public ProductModel getProductById(String id) {
        ProductDO productDO = productDao.selectByPrimaryKey(id);
        if (productDO == null) {
            return null;
        }
        StockDO stockDO = stockDao.selectByItemId(productDO.getId());

        ProductModel productModel = addStockToProduct(productDO, stockDO);

        PromoModel promoModel = promoService.getPromoByItemId(productModel.getId());
        if (promoModel.getStatus() != 3) {
            productModel.setPromoModel(promoModel);
        }
        return productModel;
    }

    private StockDO getStock(ProductModel productModel) {
        StockDO stockDO = new StockDO();
        stockDO.setStock(productModel.getStock());
        stockDO.setItemId(productModel.getId());
        stockDO.setId(String.valueOf(System.currentTimeMillis()));
        return stockDO;
    }


    @Override
    public List<ProductModel> listItem() {
        List<ProductDO> productDOList = productDao.listItem();
        return productDOList.stream().map(productDO -> {
            StockDO stockDO = stockDao.selectByItemId(productDO.getId());
            return addStockToProduct(productDO, stockDO);
        }).collect(Collectors.toList());
    }

    private ProductModel addStockToProduct(ProductDO productDO, StockDO stockDO) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDO, productModel);
        productModel.setPrice(BigDecimal.valueOf(productDO.getPrice()));
        productModel.setStock(stockDO.getStock());
        return productModel;
    }


    @Override
    public boolean decreaseStock(String itemId, Integer amount) throws ApiException {
        int affectedRow = stockDao.decreaseStock(itemId, amount);
        return affectedRow > 0;
    }

    @Override
    public void increaseSales(String itemId, Integer amount) throws ApiException {
        productDao.increaseSales(itemId, amount);
    }
}
