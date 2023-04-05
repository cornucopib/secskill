package com.cornucopib.secskill.common.api.status.impl;

import com.cornucopib.secskill.common.api.status.IApiStatus;

/**
 * Api状态信息枚举.
 *
 * @author cornucopib
 * @since 2023/4/5
 */
public enum ApiStatus implements IApiStatus {
    SUCCESS("200", "Success"), UNKNOWN_ERROR("201", "未知错误");

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
