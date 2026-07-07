package com.smartcabinet.common.exception;

import com.smartcabinet.common.enums.ErrorCodeEnum;
import lombok.Getter;

/**
 * 业务异常，主动校验失败时抛出该异常，由全局异常处理统一返回。
 */
@Getter
public class BusinessException extends RuntimeException {

    private final Integer code;

    public BusinessException(String message) {
        super(message);
        this.code = ErrorCodeEnum.BUSINESS_ERROR.getCode();
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
