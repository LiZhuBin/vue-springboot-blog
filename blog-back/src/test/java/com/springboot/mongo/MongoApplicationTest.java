package com.springboot.mongo;

import com.springboot.blog.service.ArticleClassifyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = ArticleClassifyService.class)
public class MongoApplicationTest {
    @Autowired
   // ArticleClassifyService articleClassifyService;
    @Test
    public void mongoFindTest(){
     //   System.out.println(articleClassifyService.findAll(1));
    }




}
