package com.cornucopib.secskill.order.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.status.impl.ApiStatus;
import com.cornucopib.secskill.order.dao.IOrderDao;
import com.cornucopib.secskill.order.dataobject.OrderDO;
import com.cornucopib.secskill.order.model.OrderModel;
import com.cornucopib.secskill.order.service.IOrderService;
import com.cornucopib.secskill.product.model.ProductModel;
import com.cornucopib.secskill.product.service.IProductService;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 订单服务.
 *
 * @author cornucopib
 * @since 2023/5/14
 */
public class OrderService implements IOrderService {

    @Resource
    private IProductService productService;

    @Resource
    private IOrderDao orderDao;

    @Override
    public OrderModel createOrder(Integer userId, String itemId, String promoId, Integer amount) throws ApiException {
        ProductModel productModel = productService.getProductById(itemId);

        if (amount <= 0 || amount > 99) {
            throw new ApiException(ApiStatus.ORDER_AMOUNT_ERROR);
        }

        if (!StringUtils.isEmpty(promoId)) {
            if (!promoId.equals(productModel.getPromoModel().getId())) {
                throw new ApiException(ApiStatus.PROMO_IS_RELATION_PRODUCT_ERROR);
            } else if (productModel.getPromoModel().getStatus() != 2) {
                throw new ApiException(ApiStatus.PROMO_IS_NOT_IN_PROGRESS_ERROR);
            }
        }

        boolean result = productService.decreaseStock(itemId, amount);
        if (!result) {
            throw new ApiException(ApiStatus.STOCK_NOT_ENOUGH);
        }

        OrderModel orderModel = new OrderModel();
        orderModel.setItemId(itemId);
        orderModel.setAmount(amount);
        if(promoId!=null){
            orderModel.setItemPrice(productModel.getPromoModel().getPromoItemPrice());
        }else{
            orderModel.setItemPrice(productModel.getPrice());
        }
        orderModel.setPromoId(promoId);
        orderModel.setOrderPrice(orderModel.getItemPrice().multiply(new BigDecimal(amount)));

        orderModel.setId(String.valueOf(System.currentTimeMillis()));
        OrderDO orderDO=getOrderDO(orderModel);
        orderDao.insertSelective(orderDO);

        productService.increaseSales(itemId,amount);

        return orderModel;
    }

    private OrderDO getOrderDO(OrderModel orderModel) {
        if(orderModel!=null){
            return null;
        }
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(orderModel,orderDO);
        orderDO.setItemPrice(orderModel.getItemPrice().doubleValue());
        orderDO.setOrderPrice(orderModel.getOrderPrice().doubleValue());
        return orderDO;
    }

}
