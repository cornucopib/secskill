package com.cornucopib.secskill.common;

import com.cornucopib.secskill.common.api.exception.ApiException;
import com.cornucopib.secskill.common.api.result.CommonResult;
import com.cornucopib.secskill.common.api.status.impl.ApiStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理.
 *
 * @author cornucopib
 * @since 2023/4/18
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理MethodArgumentNotValidException校验异常.
     *
     * @param e MethodArgumentNotValidException
     * @return 校验失败响应体
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<?> handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return CommonResult.failed("404", message);
    }

    /**
     * 处理BindException校验异常.
     *
     * @param e BindException
     * @return 校验失败响应体
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public CommonResult<?> handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return CommonResult.failed("404", message);
    }

    /**
     * 处理ApiException异常.
     *
     * @param apiException api异常
     * @return 校验失败响应体
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult<?> handle(ApiException apiException) {
        return CommonResult.failed(apiException);
    }

}
