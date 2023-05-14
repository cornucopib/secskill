package com.cornucopib.secskill.product.model;

import com.cornucopib.secskill.promo.model.PromoModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品Model.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
@Data
public class ProductModel {

    private String id;

    private String status;

    private String title;

    private BigDecimal price;

    private Integer stock;

    private String description;

    private Integer sales;

    private String imgUrl;

    private PromoModel promoModel;
}
