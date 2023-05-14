package com.cornucopib.secskill.order.controller;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.result.CommonResult;
import com.cornucopib.secskill.order.service.IOrderService;
import com.cornucopib.secskill.product.model.ProductModel;
import com.cornucopib.secskill.product.service.IProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author cornucopib
 * @since 2023/5/14
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @PostMapping("/create")
    public CommonResult create(@RequestParam(name="itemId")String itemId,
                               @RequestParam(name="promoId",required = false)String promoId,
                                             @RequestParam(name="amount")Integer amount
                                            ) throws ApiException {
        orderService.createOrder(1,itemId,promoId,amount);
        return CommonResult.success("");
    }
}
