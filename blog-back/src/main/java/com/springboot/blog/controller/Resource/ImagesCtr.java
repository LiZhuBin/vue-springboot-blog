package com.springboot.blog.controller.Resource;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.cos.model.COSObjectSummary;
import com.springboot.blog.entity.db.Description;
import com.springboot.blog.service.ResourcesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-13 03:26
 **/
@RestController

@RequestMapping(value = "/v1/resources")
@ResponseBody
public class ImagesCtr {


    @Autowired
    ResourcesService resourcesService;
    String basePath = "vue_springboot_blog"+"/";
//    @GetMapping("{id}")
//    public Object byAccountId(@PathVariable("id") int id){
//
//        return imagesService.byAccountId(id);
//
//    }
    @GetMapping("")
    public JSONObject classifies(@RequestParam("accountId") int accountId){

        return resourcesService.classifyByAccountId(accountId);
    }
    @GetMapping("a")
    public List<COSObjectSummary> get(){
        return resourcesService.listResources();
    }
    @GetMapping("{way}/{classify}")
    public List<Description> detail(@RequestParam("accountId") int accountId, @PathVariable("way") String way, @PathVariable("classify") String classify){
        return resourcesService.resourceClassify(accountId,way,classify);
    }

    @GetMapping("{way}/{classify}/{description}")
    public List<?> resourcesList(@RequestParam("accountId") int accountId, @PathVariable("way") String way,@PathVariable("classify") String classify, @PathVariable("description") String description){

        return resourcesService.resourceClassify(accountId,way,classify,description);
    }
    @RequestMapping(value = "{way}/{classify}/{description}/{name}",method = RequestMethod.POST,produces="application/json;charset=utf-8")
    public String upModify(@RequestParam("accountId") int accountId,
                           @PathVariable("way") String way,
                           @PathVariable("classify")String classify,
                           @PathVariable("description") String description,
                           @PathVariable("name") String name,
                           @RequestParam("multipartFile") MultipartFile file) {

        String filePath  = basePath+String.valueOf(accountId)+'/'+way+'/'+ classify +"/"+description+"/";
        return resourcesService.insertFile(file,filePath);

    }
}
