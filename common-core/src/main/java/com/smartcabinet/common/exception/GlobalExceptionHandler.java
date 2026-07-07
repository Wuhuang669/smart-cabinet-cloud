package com.smartcabinet.common.exception;

import com.smartcabinet.common.core.Result;
import com.smartcabinet.common.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器，统一把异常转换为标准接口返回格式。
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务主动抛出的异常，通常由参数校验、状态校验、余额不足、库存不足等业务场景触发。
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException exception) {
        log.warn("业务异常：{}", exception.getMessage());
        return Result.fail(exception.getCode(), exception.getMessage());
    }

    /**
     * 处理 @RequestBody 参数校验异常，方便后续接口参数统一提示。
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(fieldError -> fieldError.getField() + fieldError.getDefaultMessage())
                .orElse(ErrorCodeEnum.BAD_REQUEST.getMessage());
        log.warn("请求参数校验失败：{}", message);
        return Result.fail(ErrorCodeEnum.BAD_REQUEST.getCode(), message);
    }

    /**
     * 处理普通表单参数绑定异常。
     */
    @ExceptionHandler(BindException.class)
    public Result<Void> handleBindException(BindException exception) {
        String message = exception.getFieldErrors().stream()
                .findFirst()
                .map(fieldError -> fieldError.getField() + fieldError.getDefaultMessage())
                .orElse(ErrorCodeEnum.BAD_REQUEST.getMessage());
        log.warn("请求参数绑定失败：{}", message);
        return Result.fail(ErrorCodeEnum.BAD_REQUEST.getCode(), message);
    }

    /**
     * 兜底处理未知异常，避免异常堆栈直接暴露给前端。
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception exception) {
        log.error("系统未知异常", exception);
        return Result.fail(ErrorCodeEnum.SYSTEM_ERROR.getCode(), ErrorCodeEnum.SYSTEM_ERROR.getMessage());
    }
}
