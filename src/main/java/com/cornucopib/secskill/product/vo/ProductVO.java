package com.cornucopib.secskill.product.vo;

import com.cornucopib.secskill.promo.model.PromoModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品Model.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
@Data
public class ProductVO {

    private String id;

    private String title;

    private BigDecimal price;

    private Integer stock;

    private String description;

    private Integer sales;

    private String imgUrl;

    private Integer promoStatus;

    //秒杀活动价格
    private BigDecimal promoPrice;

    private String promoId;

    private LocalDateTime startDate;
}
