package com.springboot.blog.manager;

public class ArticleViews {
    public interface BaseView extends ResultViews.Base{}
    public interface ListView extends BaseView{}
    public interface DetailView extends ListView{}
}
