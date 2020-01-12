package com.springboot.blog.manager;

public class AccountViews {
        public interface BaseView extends ResultViews.Base{};
        public interface OthersView extends BaseView{}
        public interface SelfView extends OthersView{};
}
