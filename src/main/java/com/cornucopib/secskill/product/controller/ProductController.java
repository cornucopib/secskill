package com.cornucopib.secskill.product.controller;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.result.CommonResult;
import com.cornucopib.secskill.demo.entity.DemoEntity;
import com.cornucopib.secskill.demo.vo.DemoVO;
import com.cornucopib.secskill.product.dataobject.ProductDO;
import com.cornucopib.secskill.product.model.ProductModel;
import com.cornucopib.secskill.product.service.IProductService;
import com.cornucopib.secskill.product.vo.ProductVO;
import com.cornucopib.secskill.promo.model.PromoModel;
import org.springframework.beans.BeanUtils;
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


    @PostMapping("/create_batch")
    public CommonResult<List<ProductModel>> createBatch(@Validated @RequestBody List<ProductModel> productModelList) throws ApiException {
        return CommonResult.success(productService.createItemBatch(productModelList));
    }

    @GetMapping("/list")
    public CommonResult<List<ProductModel>> list() throws ApiException {
        List<ProductModel> productModelList = productService.listItem();
        return CommonResult.success(productModelList);
    }

    @GetMapping("/detail")
    public CommonResult<ProductVO> detail(@RequestParam(name = "id") String id) throws ApiException {
        ProductModel productModel = productService.getProductById(id);
        ProductVO productVO = getProductDO(productModel);
        return CommonResult.success(productVO);
    }

    private ProductVO getProductDO(ProductModel productModel) {
        if (productModel == null) {
            return null;
        }
        ProductVO productVO = new ProductVO();
        BeanUtils.copyProperties(productModel, productVO);
        PromoModel promoModel = productModel.getPromoModel();
        if (promoModel != null) {
            productVO.setPromoStatus(promoModel.getStatus());
            productVO.setPromoId(promoModel.getId());
            productVO.setStartDate(promoModel.getStartDate());
            productVO.setPromoPrice(promoModel.getPromoItemPrice());
        } else {
            productVO.setPromoStatus(0);
        }
        return productVO;
    }


}
