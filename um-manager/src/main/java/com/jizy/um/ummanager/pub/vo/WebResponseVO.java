package com.jizy.um.ummanager.pub.vo;


import com.jizy.um.ummanager.pub.cst.ErrorCode;

/**
 * @author jizy
 * @create 2019/4/2
 * @since 1.0.0
 */
public class WebResponseVO<T> {
    private String code;
    private String message;
    private T data;

    public WebResponseVO(String message) {
        this.code = ErrorCode.FAILED;
        this.message = message;
    }

    public WebResponseVO() {
        this.code = ErrorCode.SUCCESS;
        this.message = "请求成功";
    }

    public WebResponseVO(String code, String message, T data) {
        this.code = ErrorCode.SUCCESS;
        this.message = "请求成功";
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
