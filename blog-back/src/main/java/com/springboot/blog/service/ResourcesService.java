package com.springboot.blog.service;

import com.springboot.blog.entity.db.Resources;

import java.util.List;

public interface ResourcesService {
    public Resources byAccountId(int accountId);
    public List<String> allImages(int accountId);
    public String randomImage(int accountId);
    public List<?> detailByAccountId(String way, int accountId);
    public List<?> resourceClassify(int accountId,String way,String classify);
}
