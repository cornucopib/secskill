package com.cornucopib.secskill.common.api.exception;

import com.cornucopib.secskill.common.api.status.IApiStatus;
import lombok.SneakyThrows;

/**
 * 断言类.
 *
 * @author cornucopib
 * @since 2023/4/18
 */
public class Asserts {

    @SneakyThrows
    public static void fail(IApiStatus apiStatus) {
        throw new ApiException(apiStatus);
    }
}
