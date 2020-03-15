package com.springboot.blog.service.impl;

import com.springboot.blog.entity.db.resource.RImages;
import com.springboot.blog.service.resource.images.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-13 03:23
 **/
@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    MongoTemplate mongoTemplate;
    public Random random = new Random();
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

        RImages r = mongoTemplate.findOne(query,RImages.class);
        assert r != null;

        List<String> nameList = new ArrayList<>();

        for(RImages.DetailBeanXX s:r.getDetail()){
            if(s.getPower().equals("private")) break;
            for(RImages.DetailBeanXX.DetailBeanX detailBean:s.getDetail()){
                for (RImages.DetailBeanXX.DetailBeanX.DetailBean bean:detailBean.getDetail()){
                    nameList.add(bean.getUrl());
                }

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
    public RImages findAll(int accountId,String classify) {
        Criteria criteria = new Criteria();
        Query query = new Query();
        criteria.and("account_id").is(accountId);
        criteria.andOperator(Criteria.where("detail").elemMatch(Criteria.where("classify").is(classify)));
        query.addCriteria(criteria);


        RImages r = mongoTemplate.findOne(query,RImages.class);
        return r;
    }
    @Override
    public RImages findAll(int accountId,String classify,String description) {
        Criteria criteria = new Criteria();
        Query query = new Query();
        criteria.and("account_id").is(accountId);
        criteria.andOperator(Criteria.where("detail").elemMatch(Criteria.where("classify").is(classify).andOperator(Criteria.where("detail").elemMatch(Criteria.where("classify").is(description)))));
        query.addCriteria(criteria);


        RImages r = mongoTemplate.findOne(query,RImages.class);
        return r;
    }
}
