package com.cornucopib.secskill.common.api.exception;

import com.cornucopib.secskill.common.api.status.IApiStatus;

/**
 * API异常.
 *
 * @author cornucopib
 * @since 2023/4/5
 */
public class ApiException extends Exception implements IApiStatus {

    private IApiStatus apiStatus;

    public ApiException(IApiStatus apiStatus) {
        super();
        this.apiStatus = apiStatus;
    }

    public ApiException(IApiStatus apiStatus, String message) {
        super();
        this.apiStatus = apiStatus;
        this.apiStatus.setMessage(message);
    }

    @Override
    public String getCode() {
        return apiStatus.getCode();
    }

    @Override
    public String getMessage() {
        return apiStatus.getMessage();
    }

    @Override
    public IApiStatus setMessage(String message) {
        apiStatus.setMessage(message);
        return this;
    }
}
