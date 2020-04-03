package com.springboot.blog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.manager.ResultViews;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.http.HttpStatus;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Result<T> {


    @JsonView(ResultViews.Base.class)
    private Integer code;

    public Result() {
    }
    @JsonView(ResultViews.Base.class)
    private String message;
    @JsonView(ResultViews.Base.class)
    private T data;

    public Result(HttpStatus ok, Object body) {
    }

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



    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;

        this.data = data;
    }
    public  Result<String> faith(){

            return new Result<>(HttpStatus.NOT_FOUND.value(),"查找失败"," ");
    }
    public  Result<T> success(T data){
        return new Result<T>(HttpStatus.OK.value(), "success", data);
    }
}
