package com.springboot.blog.config;

import com.springboot.blog.entity.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.constraints.Null;
import javax.xml.ws.Response;
import java.util.Optional;

@ControllerAdvice
class MyResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

            if(body instanceof Optional&&!((Optional) body).isPresent()||body==null){
               return new Result<>().faith();
            }
            return new Result<>().success(body);


    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class clas) {
       return true;
    }
}