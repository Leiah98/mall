package com.leiah.mall.tiny.common.api;

/**
 * @Author: Leiah
 * @Description: 枚举了一些常用的API操作码
 * @Date: 2020/9/6 9:32
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数校验失败"),
    UNAUTHORIZED(401, "未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
