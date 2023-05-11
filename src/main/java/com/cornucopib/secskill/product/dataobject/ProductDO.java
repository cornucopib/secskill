package com.cornucopib.secskill.product.dataobject;

import lombok.Data;

/**
 * 商品DO.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
@Data
public class ProductDO {

    private String id;

    private String title;

    private Double price;

    private String description;

    private Integer sales;

    private String imgUrl;
}
