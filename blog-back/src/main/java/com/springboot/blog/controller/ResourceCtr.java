package com.springboot.blog.controller;

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
public class ResourceCtr {


    @Autowired
    ResourcesService resourcesService;
    String basePath = "vue_springboot_blog"+"/";

    @GetMapping("")
    public JSONObject classifies(@RequestParam("accountId") int accountId){

        return resourcesService.classifyByAccountId(accountId);
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
                           @RequestParam("multipartFile") MultipartFile file,
                           @RequestParam("power") boolean power) {

        String filePath  = basePath+String.valueOf(accountId)+'/'+way+'/'+ classify +"/"+description+"/";
        String newPath = resourcesService.insertFile(file,filePath);
        resourcesService.insertFileDb(classify,description,name,way,newPath,accountId,power);
        return newPath;

    }
    @RequestMapping(value = "test")
    public void test(@RequestParam("multipartFile") MultipartFile file){

    }
}
