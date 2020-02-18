package com.springboot.blog.service.impl;

import com.springboot.blog.entity.db.Resources;
import com.springboot.blog.repository.ResourcesRepository;
import com.springboot.blog.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: vue-springboot-blog
 * @description: 资源模块的功能实现类
 * @author: LiZhuBin
 * @create: 2020-02-11 18:37
 **/
@Service

public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    ResourcesRepository resourcesRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    public Random random = new Random();
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
    * @Description: 得到所有公开的图片
    * @Param: [accountId]
    * @return: java.util.List<java.lang.String>
    */
    public List<String> allImages(int accountId) {
        Criteria criteria = new Criteria();
        criteria.and("account_id").is(accountId);
        Query query = new Query(criteria);

        Resources r = mongoTemplate.findOne(query,Resources.class);
        assert r != null;

        List<String> nameList = new ArrayList<>();

        for(Resources.ImagesBean s:r.getImages()){
            if(s.getPower().equals("private")) break;
            for(Resources.ImagesBean.DetailBean detailBean:s.getDetail()){
                nameList.add(detailBean.getUrl());
            }
        }
        return nameList;
    }

    @Override
    public String randomImage(int accountId) {
        List<String> allImages = allImages(accountId);
        if(allImages.size()==0) return "";
        return allImages.get(random.nextInt(allImages.size()));
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

    @Override
    public List<?> resourceClassify(int accountId, String way, String classify) {

        Criteria criteria = new Criteria();
        criteria.and("account_id").is(accountId);
        criteria.and("images.classify").is(classify);
                Aggregation aggregation = Aggregation.newAggregation(
          Aggregation.match(criteria)
        );
        Query query = new Query(criteria);

        Resources r = mongoTemplate.findOne(query,Resources.class);
        List<?> objects = detailByAccountId(r, way);
        return objects;
    }

    @Override
    public List<?> detail(int accountId, String way, String classify, String name) {
        Criteria criteria = new Criteria();
        criteria.and("account_id").is(accountId);
        criteria.and("images.classify").is(classify);
        criteria.and("images.description").is(name);
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria)
        );
        Query query = new Query(criteria);

        Resources r = mongoTemplate.findOne(query,Resources.class);
        List<?> objects = detailByAccountId(r, way);
        return objects;
    }


}
