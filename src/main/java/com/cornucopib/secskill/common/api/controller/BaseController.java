package com.cornucopib.secskill.common.api.controller;

import com.cornucopib.secskill.common.api.result.CommonResult;
import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.status.impl.ApiStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller基类.
 *
 * @author cornucopib
 * @since 2023/4/5
 */
public class BaseController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        if (ex instanceof ApiException) {
            ApiException apiException = (ApiException) ex;
            return CommonResult.failed(apiException);
        } else {
            return CommonResult.failed(ApiStatus.UNKNOWN_ERROR);
        }
    }
}
