package com.cornucopib.secskill.common.api.status.impl;

import com.cornucopib.secskill.common.api.status.IApiStatus;

/**
 * Api状态信息枚举.
 *
 * @author cornucopib
 * @since 2023/4/5
 */
public enum ApiStatus implements IApiStatus {
    SUCCESS("200", "Success"),
    UNKNOWN_ERROR("201", "未知错误"),

    RE_REGISTER_ERROR("203","重复注册手机号"),

    LOGIN_ERROR("204","登录失败!"),

    ORDER_AMOUNT_ERROR("305","金额数量必须大于0且小于99"),

    PROMO_IS_RELATION_PRODUCT_ERROR("306","商品不存在该秒杀活动!"),
    PROMO_IS_NOT_IN_PROGRESS_ERROR("307","秒杀活动没有进行!"),
    STOCK_NOT_ENOUGH("308","库存不足"),
    ;



    private final String code;
    private String message;

    ApiStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IApiStatus setMessage(String message) {
        this.message = message;
        return this;
    }
}
