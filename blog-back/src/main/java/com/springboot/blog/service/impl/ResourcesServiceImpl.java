package com.springboot.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableList;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.ListObjectsRequest;
import com.qcloud.cos.model.ObjectListing;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.*;
import com.springboot.blog.repository.ResourceRepository;
import com.springboot.blog.service.ResourcesService;
import com.springboot.blog.utils.COSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description: 资源模块的功能实现类
 * @author: LiZhuBin
 * @create: 2020-02-11 18:37
 **/
@Service

public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    ResourceRepository resourcesRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    // 1 初始化用户身份信息（secretId, secretKey）。
    String secretId = "1258635419";
    String secretKey = "jEXUCpHgqlaDSRBmywjHai4IHyQcSRDs";
    QClassify classify = QClassify.classify;
    QDescription description = QDescription.description;
    QResource resource = QResource.resource;






    public List<Description> getDescription(int accountId,String c,String way){

        return jpaQueryFactory.select(description).from(classify,description).where(classify.name.eq(c).and(classify.type.eq(way)).and(classify.id.eq(description.classifyId))).fetch();
    }
    public List<Description> getDescription(int accountId,String c,String way,String d){

        return jpaQueryFactory.select(description).from(classify,description).where(description.name.eq(d).and(classify.name.eq(c)).and(classify.type.eq(way)).and(classify.id.eq(description.classifyId))).fetch();
    }
    public List<Resource> getResource(int accountId,List<Description> d){

        List<Resource> resourceList = new ArrayList<>();

        for(Description description:d){
            resourceList.addAll(jpaQueryFactory.select(resource).from(resource).where(resource.descriptionId.eq(description.getId())).fetch());

        }
        return resourceList;
    }

    @Override
    public List<Description> resourceClassify(int accountId, String way, String classify) {

        return getDescription(accountId,classify,way);
    }

    @Override
    public List<Resource> resourceClassify(int accountId, String way, String classify, String description) {
        return getResource(accountId,getDescription(accountId,classify,way,description)) ;
    }

    @Override
    public List<?> detail(int accountId, String way, String classify, String description) {

      //  return getResource(accountId,classify,description);
        return null;
    }

    @Override
    public String randomImage() {
        List<Resource> r = resourceClassify(1,"images","动漫","东京食尸鬼");
        Collections.shuffle(r);
        return r.get(0).getUrl();
    }

    @Override
    public JSONObject classifyByAccountId(int accountId) {
        JSONObject object = new JSONObject();
        List<String> classifyTypes = ImmutableList.of("images","videos","files");
        for(String type:classifyTypes){

            List<String> typeList = jpaQueryFactory.select(classify.name).from(classify).where(classify.accountId.eq(accountId).and(classify.type.eq(type))).fetch();
            object.put(type,typeList);
        }
        return object;
    }

    @Override
    public void insertDbFile(String way, String name, String classify, String description, String url) {

    }

    @Override
    public Classify insertClassify(Classify classify) {

        return null;
    }

    @Override
    public String insertFile(MultipartFile file, String filePath) {
        String img_url = null;

        try {

            COSClientUtil cosClientUtil = new COSClientUtil();

            if(!file.isEmpty()) {

                String name = cosClientUtil.uploadFile2Cos(file,filePath);
                //图片名称
                System.out.println("name = " + name);
                //上传到腾讯云
                img_url = cosClientUtil.getImgUrl(name);
            }
        } catch (Exception e) {
            e.printStackTrace();


        }
        return img_url;
    }

    @Override
    public List<COSObjectSummary> listResources() {
        return  new COSClientUtil().listResources();
    }


}
