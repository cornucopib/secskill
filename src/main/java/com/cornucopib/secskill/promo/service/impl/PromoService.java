package com.cornucopib.secskill.promo.service.impl;

import com.cornucopib.secskill.promo.dao.IPromoDao;
import com.cornucopib.secskill.promo.dataobject.PromoDO;
import com.cornucopib.secskill.promo.model.PromoModel;
import com.cornucopib.secskill.promo.service.IPromoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

/**
 * @author cornucopib
 * @since 2023/5/13
 */
@Service
public class PromoService implements IPromoService {

    @Resource
    private IPromoDao promoDao;

    @Override
    public PromoModel getPromoByItemId(String itemId) {
        PromoDO promoDO = promoDao.selectByItemId(itemId);
        PromoModel promoModel = getPromoModel(promoDO);
        if (promoModel == null) {
            return null;
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDate = promoModel.getStartDate();
        LocalDateTime endDate = promoModel.getEndDate();

        if (startDate.isAfter(now)) {
            promoModel.setStatus(1);
        }else if(endDate.isBefore(now)){
            promoModel.setStatus(3);
        }else{
            promoModel.setStatus(2);
        }
        return promoModel;
    }

    private PromoModel getPromoModel(PromoDO promoDO) {
        if (promoDO == null) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO, promoModel);
        promoModel.setPromoItemPrice(BigDecimal.valueOf(promoDO.getPromoItemPrice()));
        promoModel.setStartDate(promoDO.getStartDate());
        promoModel.setEndDate(promoDO.getEndDate());
        return promoModel;
    }
}
