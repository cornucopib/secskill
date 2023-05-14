package com.cornucopib.secskill.promo.dataobject;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author cornucopib
 * @since 2023/5/10
 */
@Data
public class PromoDO {

    private String id;

    private String promoName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String itemId;

    private Double promoItemPrice;
}
