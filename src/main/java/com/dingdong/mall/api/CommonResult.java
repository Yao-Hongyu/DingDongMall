package com.dingdong.mall.api;

import lombok.Data;

/**
 * 通用返回对象
 */
@Data
public class CommonResult<T> {
    /**
     * 状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     * @param
     */
    public static <T> CommonResult<T> success(){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(),null);
    }

    /**
     * 失败返回结果
     * @param message 错误信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 登陆成功
     */
    public static <T> CommonResult<T> loginSuccess(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), "登陆成功",data);
    }

    public static <T> CommonResult<T> loginFailed(){
        return new CommonResult<>(ResultCode.FAILED.getCode(),"登陆失败，用户名或密码错误",null);
    }

}
