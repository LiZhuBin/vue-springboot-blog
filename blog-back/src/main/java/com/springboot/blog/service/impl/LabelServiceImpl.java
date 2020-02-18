package com.springboot.blog.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.ArticleClassify;
import com.springboot.blog.entity.db.Label;
import com.springboot.blog.entity.db.QLabel;
import com.springboot.blog.repository.LabelRepository;
import com.springboot.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelRepository labelRepository;
@Autowired
    private JPAQueryFactory jpaQueryFactory;
    QLabel label = QLabel.label;

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<String> getArticleLabels(int articleId) {
        Criteria criteria = new Criteria();
        criteria.and("article_id").is(articleId);
        Query query = new Query(criteria);
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria)
        );
        return mongoTemplate.aggregate(aggregation,"article_classify",ArticleClassify.class).getUniqueMappedResult().getLabels();

    }

    @Override
    public List<Map> getAccountLabels(int accountId) {
        return null;
    }

    @Override
    public Label getLabelByLabelId(int labelId) {


            return jpaQueryFactory.selectFrom(label)
                    .where(label.id.eq(labelId))
                    .fetchOne();


    }
}
