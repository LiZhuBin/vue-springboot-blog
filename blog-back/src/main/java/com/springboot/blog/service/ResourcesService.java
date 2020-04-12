package com.springboot.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.springboot.blog.entity.db.Description;
import com.springboot.blog.entity.db.Resource;

import java.util.List;

public interface ResourcesService {

    List<Description>resourceClassify(int accountId, String way, String classify);
    List<Resource> resourceClassify(int accountId, String way, String classify,String description);
    List<?> detail(int accountId,String way,String classify,String description);
    String randomImage();
    JSONObject classifyByAccountId(int accountId);
}
