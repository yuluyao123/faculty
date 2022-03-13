package com.example.faculty.util.model;

import lombok.Data;

@Data
public class PageRequest extends LoginRequest {

    /**
     * 起始行
     */
    private int beginRow;

    /**
     * 结束行
     */
    private int endRow;
}
