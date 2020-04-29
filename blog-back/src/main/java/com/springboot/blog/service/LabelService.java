package com.springboot.blog.service;

import com.springboot.blog.entity.db.Label;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface LabelService  {
    Set<String> getArticleLabels(int articleId);


    Label getLabelByLabelId(int labelId);
    List<Label> byLabelName(String labelName);
    void insertLabels(List<Label> l);
    void insertLabel(Label l);
}
