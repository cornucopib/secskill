package com.cornucopib.secskill.product.model;

import lombok.Data;

/**
 * 商品Model.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
@Data
public class ProductModel {

    private String id;

    private String title;

    private Double price;

    private Integer stock;

    private String description;

    private Integer sales;

    private String imgUrl;

    private ProductModel promoModel;
}
