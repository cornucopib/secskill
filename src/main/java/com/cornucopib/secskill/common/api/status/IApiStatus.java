package com.cornucopib.secskill.common.api.status;

/**
 * API状态信息接口.
 *
 * @author cornucopib
 * @since 2023/4/5
 */
public interface IApiStatus {
    /**
     * 获取状态码
     *
     * @return 状态码
     */
    String getCode();

    /**
     * 获取状态信息
     *
     * @return
     */
    String getMessage();

    /**
     * 设置状态信息
     */
    IApiStatus setMessage(String message);
}
