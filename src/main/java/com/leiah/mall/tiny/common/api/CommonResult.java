package com.leiah.mall.tiny.common.api;

/**
 * @Author: Leiah
 * @Description: 通用返回对象
 * @Date: 2020/9/6 9:27
 */
public class CommonResult<T> {
    private Long code;
    private String message;
    private T data;

    public CommonResult() {

    }

    public CommonResult(Long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
    * @Description: 成功返回结果
    * @Param: [data] 获取的数据
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T> 
    * @Date: 2020/9/6 9:48
    **/
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
    * @Description: 成功返回结果
    * @Param: [data, message] 获取的数据，提示信息
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T>
    * @Date: 2020/9/6 9:50
    **/
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
    * @Description: 失败返回结果
    * @Param: [errorCode] 错误码
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T> 
    * @Date: 2020/9/6 9:53
    **/
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
    * @Description: 失败返回结果
    * @Param: [message] 提示信息
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T>
    * @Date: 2020/9/6 9:54
    **/
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
    * @Description: 失败返回结果
    * @Param: []
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T>
    * @Date: 2020/9/6 9:57
    **/
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
    * @Description: 参数验证失败返回结果
    * @Param: []
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T>
    * @Date: 2020/9/6 10:21
    **/
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
    * @Description: 参数验证失败返回结果
    * @Param: [message]
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T>
    * @Date: 2020/9/6 10:23
    **/
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
    * @Description: 未登录返回结果
    * @Param: [data]
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T> 
    * @Date: 2020/9/6 10:33
    **/
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
    * @Description: 未授权返回结果
    * @Param: [data]
    * @Return: com.leiah.mall.tiny.common.api.CommonResult<T> 
    * @Date: 2020/9/6 10:35
    **/
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
    
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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
