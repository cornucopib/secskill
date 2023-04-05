package com.cornucopib.secskill.common.api;

import com.cornucopib.secskill.common.api.status.IApiStatus;
import com.cornucopib.secskill.common.api.status.impl.ApiStatus;

/**
 * 公共的返回结果.
 *
 * @author cornucopib
 * @since 2023/4/5
 */
public class CommonResult<T> {

    private String code;
    private String message;
    private T data;

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ApiStatus.SUCCESS, data);
    }

    public static <T> CommonResult<T> failed(IApiStatus apiStatus) {
        return new CommonResult<>(apiStatus);
    }

    public static <T> CommonResult<T> failed(String code, String message) {
        return new CommonResult<>(code, message);
    }

    public CommonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public CommonResult(IApiStatus apiStatus) {
        this.code = apiStatus.getCode();
        this.message = apiStatus.getMessage();
    }

    public CommonResult(IApiStatus apiStatus, T data) {
        this.code = apiStatus.getCode();
        this.message = apiStatus.getMessage();
        this.data = data;
    }

    public CommonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
