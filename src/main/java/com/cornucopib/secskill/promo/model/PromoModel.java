package com.cornucopib.secskill.promo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author cornucopib
 * @since 2023/5/10
 */
@Data
public class PromoModel {

    private String id;

    private Integer status;

    private String promoName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String itemId;

    private BigDecimal promoItemPrice;
}
