package com.cornucopib.secskill.promo.service;

import com.cornucopib.secskill.promo.model.PromoModel;

/**
 * @author cornucopib
 * @since 2023/5/13
 */
public interface IPromoService {

    PromoModel getPromoByItemId(String itemId);
}
