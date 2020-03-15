package com.springboot.blog.service.resource.images;

import com.springboot.blog.entity.db.resource.RImages;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-13 03:21
 **/
public interface ImagesService {
    public List<String> allImages(int accountId);
    public String randomImage(int accountId);
    RImages findAll(int accountId,String classify);
    RImages findAll(int accountId,String classify,String description);
}
