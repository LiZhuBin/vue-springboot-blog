package com.springboot.blog.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.*;
import com.springboot.blog.repository.LabelRepository;
import com.springboot.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelRepository labelRepository;
@Autowired
    private JPAQueryFactory jpaQueryFactory;
    QLabel label = QLabel.label;
    QArticle article = QArticle.article;

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<String> getArticleLabels(int articleId) {

        List<String> s = new ArrayList<>();
        List<Label> fetch = labelRepository.findAllByArticleId(articleId);
        for(Label label:fetch){
            s.add(label.getLabelName());
        }
        return  s;
    }



    @Override
    public Label getLabelByLabelId(int labelId) {


            return jpaQueryFactory.selectFrom(label)
                    .where(label.id.eq(labelId))
                    .fetchOne();


    }

    @Override
    public List<Label> byLabelName(String labelName) {
        return labelRepository.findAllByLabelName(labelName);
    }
}
