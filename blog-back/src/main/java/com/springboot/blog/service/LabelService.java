package com.springboot.blog.service;

import com.springboot.blog.entity.db.Label;

import java.util.List;
import java.util.Map;

public interface LabelService  {
    public List<Map> getArticleLabels(int articleId);
    public List<Map> getAccountLabels(int accountId);
    Label getLabelByLabelId(int labelId);
}
