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

    @Override
    public Resources byAccountId(int accountId) {
        Query query = new Query(Criteria.where("account_id").is(accountId));
        return mongoTemplate.findOne(query,Resources.class);
    }



    @Override
    /**
    * @Description: 得到相应文件类型下的数据
    * @Param: [way, accountId]
    * @return: java.util.List<?>
    */
    public List<?> detailByAccountId( Resources resources,String way) {

        if ("images".equals(way)) {

            return resources.getImages();
        }else if("video".equals(way)){
            return resources.getVideos();
        }else if("files".equals(way)){
            return resources.getVideos();
        }
        return null;

    }
    public List<Description> getDescription(int accountId,String classify){
        QClassify classify1 = QClassify.classify;
        QDescription description = QDescription.description;
        return jpaQueryFactory.select(description).from(classify1,description).where(classify1.name.eq(classify).and(classify1.id.eq(description.classifyId))).fetch();
    }
    public List<Resource> getResource(int accountId,List<Description> d){
        QResource resource = QResource.resource;
        List<Resource> resourceList = new ArrayList<>();

        for(Description description:d){
            resourceList.addAll(jpaQueryFactory.select(resource).from(resource).where(resource.descriptionId.eq(description.getId())).fetch());

        }
        return resourceList;
    }
    public List<Resource> getResource(int accountId,String c,String d){
        QResource resource = QResource.resource;
        List<Resource> resourceList = new ArrayList<>();

        for(Description description:getDescription(accountId,c)){
            resourceList.addAll(jpaQueryFactory.select(resource).from(resource).where(resource.descriptionId.eq(description.getId())).fetch());

        }
       return resourceList;
    }
    @Override
    public List<Resource> resourceClassify(int accountId, String way, String classify) {

        QResource resource = QResource.resource;
        QClassify classify1 = QClassify.classify;
//        BooleanBuilder builder = new BooleanBuilder();
//        builder.and(resource.accountId.eq(accountId));
        return getResource(accountId,getDescription(accountId,classify)) ;
    }

    @Override
    public List<?> detail(int accountId, String way, String classify, String description) {

        return getResource(accountId,classify,description);
    }


}
