package com.example.faculty.util.model;

import lombok.Data;

@Data
public class PageDTO extends LoginRequest {

    /**
     * 页码
     */
    private int pageNum = 1;

    /**
     * 页面容量
     */
    private int pageSize = 10;

    public Integer getStartRow() {
        return pageSize * (pageNum - 1);
    }
}
