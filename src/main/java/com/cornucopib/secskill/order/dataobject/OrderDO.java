package com.cornucopib.secskill.order.dataobject;

import lombok.Data;

/**
 * @author cornucopib
 * @since 2023/5/10
 */
@Data
public class OrderDO {

    private String id;

    private Integer userId;

    private String itemId;

    private Double itemPrice;

    private Integer amount;

    private Double orderPrice;

    private Integer promoId;
}
