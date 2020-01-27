package com.springboot.blog.shell;

import com.springboot.blog.service.ArticleService;
import com.springboot.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

public class labelShell {
    @Autowired
    LabelService labelService;
    @Autowired
    ArticleService articleService;

    public void createLabels(){
        RedisTemplate redisTemplate = new RedisTemplate();
        SetOperations setOperations = redisTemplate.opsForSet();

        setOperations.add("f","f");
        System.out.println(setOperations.members("f"));
    }


}
