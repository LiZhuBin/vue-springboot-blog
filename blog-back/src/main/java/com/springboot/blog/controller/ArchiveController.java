package com.springboot.blog.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Article;
import com.springboot.blog.manager.ArticleViews;
import com.springboot.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description: archive
 * @author: LiZhuBin
 * @create: 2020-02-09 23:02
 **/
@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class ArchiveController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("archive/{year}/{month}")
    @JsonView(ArticleViews.ListView.class)
    /**
    * @Description: 通过年月得到文章列表
    * @Param: [accountId, year, month]
    * @return: java.util.List<com.springboot.blog.entity.db.Article>
    */
    public List<Article> getArticlesByLabelId(@RequestParam("accountId") int accountId, @PathVariable(value = "year") int year, @PathVariable(value = "month") int month ){

        return articleService.getArticlesByArchive(accountId,String.valueOf(year),String.format("%02d",month));
    }
}
