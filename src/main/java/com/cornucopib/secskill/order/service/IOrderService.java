package com.cornucopib.secskill.order.service;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.order.model.OrderModel;

/**
 * 订单服务接口.
 *
 * @author cornucopib
 * @since 2023/5/14
 */
public interface IOrderService {

    OrderModel createOrder(Integer userId, String itemId, String promoId, Integer amount) throws ApiException;

}
