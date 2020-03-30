package com.springboot.blog.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.blog.entity.db.*;
import com.springboot.blog.repository.ResourceRepository;
import com.springboot.blog.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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


}
