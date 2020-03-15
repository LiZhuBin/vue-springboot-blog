package com.springboot.blog.controller.Resource;

import com.springboot.blog.entity.db.Resource;
import com.springboot.blog.service.ResourcesService;
import com.springboot.blog.service.resource.images.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-13 03:26
 **/
@RestController

@RequestMapping(value = "/v1/resources/images")
@ResponseBody
public class ImagesCtr {
    @Autowired
    ImagesService imagesService;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    ResourcesService resourcesService;
//    @GetMapping("{id}")
//    public Object byAccountId(@PathVariable("id") int id){
//
//        return imagesService.byAccountId(id);
//
//    }

    @GetMapping("{classify}")
    public List<Resource> detail(@RequestParam("accountId") int accountId, @PathVariable("classify") String classify){
        return resourcesService.resourceClassify(accountId,"images",classify);
    }

    @GetMapping("{classify}/{description}")
    public List<?> resourcesList(@RequestParam("accountId") int accountId, @PathVariable("classify") String classify, @PathVariable("description") String description){

        return resourcesService.resourceClassify(accountId,"images",classify);
    }
}
