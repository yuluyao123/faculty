package com.example.faculty.util.model;

import lombok.Data;

@Data
public class WebResult<T> {

    /**
     * 状态
     */
    private boolean success = false;

    /**
     * 数据
     */
    private T result;

    /**
     * 数量
     */
    private Integer total;

    /**
     * 返回信息
     */
    private String message;

    public WebResult() {
    }


    public WebResult(boolean success, T result, String message) {
        this.success = success;
        this.result = result;
        this.message = message;
    }

    public WebResult(boolean success, T result, Integer total, String message) {
        this.success = success;
        this.result = result;
        this.total = total;
        this.message = message;
    }


    public static <T> WebResult success(T result){
        return new WebResult(true, result, null);

    }

    public static <T> WebResult success(T result, Integer total){
        return new WebResult(true, result, total, null);

    }

    public static <T> WebResult error(T result){
        return new WebResult(false, result, null);

    }

    public static <T> WebResult error(T result, String message){
        return new WebResult(false, result, message);

    }





}
