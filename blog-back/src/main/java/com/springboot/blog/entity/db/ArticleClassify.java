package com.springboot.blog.entity.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Document(collection="article_classify")//集合名
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ArticleClassify implements Serializable {

    /**
     * _id : 5e36d5341c91414f8118a77b
     * article_id : 1
     * account_id : 1
     * labels : ["vue.js","html"]
     * classify : ["前端"]
     */

    private String id;
    private int articleId;
    private int accountId;
    private List<String> labels;
    private List<String> classify;
}
