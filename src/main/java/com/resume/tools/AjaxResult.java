package com.resume.tools;

import java.io.Serializable;

/**
 * @author shiyanlou
 */
public class AjaxResult implements Serializable {
    private int code = 200;
    private Object data;
    private String message = "操作成功";

    public AjaxResult() {
    }

    public AjaxResult(String message) {
        this.message = message;
    }

    public AjaxResult(Object data) {
        this.data = data;
    }

    public AjaxResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AjaxResult(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
