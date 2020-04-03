package com.springboot.blog.config;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.blog.entity.ErrorCode;
import com.springboot.blog.entity.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Optional;

@ControllerAdvice
class MyResponseBodyAdvice implements ResponseBodyAdvice {


    /**
    * @Description: 在controller反回的数据封装成Result对象
    * @Param: [body, returnType, selectedContentType, selectedConverterType, request, response]
    * @return: java.lang.Object
    */
    private ThreadLocal<ObjectMapper>  mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);

    private static final Class[] annos = {
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class
    };
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        AnnotatedElement element = returnType.getAnnotatedElement();
        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
    }
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

//            if(body instanceof Optional&&!((Optional) body).isPresent()||body==null){
//               return new Result<>().faith();
//            }
//            return new Result<>().success(body);

        Object out;
        ObjectMapper mapper = mapperThreadLocal.get();

        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if(body instanceof Result){
            out = body;
        }
        else if (body instanceof ErrorCode){
            ErrorCode errorCode = (ErrorCode) body;
            out = new Result(errorCode.getCode(),errorCode.getMsg(),"");
        }
        else if (body instanceof String){
            Result result = new Result(200,"",body);
            try {
                out = mapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                out = new Result(ErrorCode.JSON_PARSE_ERROR.getCode(),e.getMessage(),"");
            }
        }
        else{
            out = new Result(200,"",body);
        }
        return out;
    }

    }
