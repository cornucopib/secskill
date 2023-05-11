package com.cornucopib.secskill.stock.dataobject;

import lombok.Data;

/**
 * 库存DO.
 *
 * @author cornucopib
 * @since 2023/5/10
 */
@Data
public class StockDO {

    private String id;

    private Integer stock;

    private String itemId;

}
