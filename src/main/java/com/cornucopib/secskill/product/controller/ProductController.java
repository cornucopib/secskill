package com.cornucopib.secskill.product.controller;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.result.CommonResult;
import com.cornucopib.secskill.demo.entity.DemoEntity;
import com.cornucopib.secskill.demo.vo.DemoVO;
import com.cornucopib.secskill.product.model.ProductModel;
import com.cornucopib.secskill.product.service.IProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cornucopib
 * @since 2023/5/13
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private IProductService productService;

    @PostMapping("/create")
    public CommonResult<ProductModel> create(@Validated @RequestBody ProductModel productModel) throws ApiException {
        return CommonResult.success(productService.createItem(productModel));
    }

    @GetMapping("/list")
    public CommonResult<List<ProductModel>> list() throws ApiException {
        List<ProductModel> productModelList = productService.listItem();
        return CommonResult.success(productModelList);
    }

}
