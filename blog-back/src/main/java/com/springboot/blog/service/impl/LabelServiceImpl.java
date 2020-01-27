package com.springboot.blog.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.Label;
import com.springboot.blog.entity.db.QLabel;
import com.springboot.blog.repository.LabelRepository;
import com.springboot.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelRepository labelRepository;
@Autowired
    private JPAQueryFactory jpaQueryFactory;
    @Override
    public List<Map> getArticleLabels(int articleId) {
        return labelRepository.getLabelsByArticleId(articleId);
    }

    @Override
    public List<Map> getAccountLabels(int accountId) {
        return labelRepository.getLabelsByAccountId(accountId);
    }

    @Override
    public Label getLabelByLabelId(int labelId) {

            QLabel label = QLabel.label;
            return jpaQueryFactory.selectFrom(label)
                    .where(label.id.eq(labelId))
                    .fetchOne();


    }
}
