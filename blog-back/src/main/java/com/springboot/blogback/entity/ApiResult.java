package com.springboot.blogback.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.nashorn.internal.objects.annotations.Getter;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResult<T> {


    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    private T data;

    public ApiResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
