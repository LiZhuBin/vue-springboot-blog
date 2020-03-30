package com.springboot.blog.service;

import com.springboot.blog.entity.db.Label;

import java.util.List;
import java.util.Map;

public interface LabelService  {
    List<String> getArticleLabels(int articleId);


    Label getLabelByLabelId(int labelId);
    List<Label> byLabelName(String labelName);
}
