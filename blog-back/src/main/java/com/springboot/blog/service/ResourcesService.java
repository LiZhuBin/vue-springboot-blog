package com.springboot.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.cos.model.COSObjectSummary;
import com.springboot.blog.entity.db.Classify;
import com.springboot.blog.entity.db.Description;
import com.springboot.blog.entity.db.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResourcesService {

    List<Description>resourceClassify(int accountId, String way, String classify);
    List<Resource> resourceClassify(int accountId, String way, String classify,String description);
    List<?> detail(int accountId,String way,String classify,String description);
    String randomImage();
    JSONObject classifyByAccountId(int accountId);
    void insertDbFile(String way,String name,String classify,String description,String url);
    Classify insertClassify(Classify classify);
    String insertFile(MultipartFile file,String filePath);
    List<COSObjectSummary> listResources();
    void insertFileDb(String c,String d,String name,String way,String newPath,int accountId,boolean power);
}
