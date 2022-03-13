package com.example.faculty.util.model;

import lombok.Data;

@Data
public class WebResult<T> {

    /**
     * 数据
     */
    private T data;

    /**
     * 状态
     */
    private boolean status;

    /**
     * 返回信息
     */
    private String message;

    public WebResult() {
    }


    public WebResult(T data) {
        this.data = data;
    }


    public static WebResult success(Object data){
        WebResult result = new WebResult(data);
        result.status = true;
        return result;

    }






}
