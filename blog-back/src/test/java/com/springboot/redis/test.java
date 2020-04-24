package com.springboot.redis;

import com.mysema.commons.lang.Assert;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-22 12:29
 **/
@Log4j2
public class test {
    RestTemplate restTemplate = new RestTemplate();
//    @Autowired
//    RedisTemplate redisTemplate;
//    @Test
//    public void t(){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("a","aaa");
//
//    }

    @Test
    public void r(){
        String url = "http://localhost:9877/v1/articles/1";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("get_product1返回结果：" + result);
        Assert.hasText(result, "get_product1返回结果为空");

    }
}
