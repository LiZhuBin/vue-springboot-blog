package com.springboot.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class ArticleDateClassify implements Serializable {
    String year;
    String month;

    @Override
    public String toString() {
        return year+month;
    }
}
