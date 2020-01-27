package com.springboot.blog;

import com.springboot.blog.service.ArticleService;
import com.springboot.blog.service.LabelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    LabelService labelService;
    @Autowired
    ArticleService articleService;

    public void createLabels(){

    }
    @Test
    void contextLoads() {


    }

}
