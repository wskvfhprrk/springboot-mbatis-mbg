package com.example.common;

import lombok.Data;

import java.util.List;

@Data
public class PageResponseEntity<T> {
    private Long totle;
    private Integer pageSize;
    private Integer pageNumber;
    private List<T> pages;


}
