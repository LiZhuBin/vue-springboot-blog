package com.springboot.blog.controller;

import com.springboot.blog.entity.db.Resources;
import com.springboot.blog.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: vue-springboot-blog
 * @description: 资源控制类
 * @author: LiZhuBin
 * @create: 2020-02-11 18:39
 **/

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class ResourceController {
    @Autowired
    ResourcesService resourcesService;
    @GetMapping("/resources/{id}")
    public Resources byAccountId(@PathVariable("id") int id){
        return resourcesService.byAccountId(id);

    }
    @GetMapping("/resources/images/{id}")
    public List<String> allImages(@PathVariable("id") int id){
        return resourcesService.allImages(id);
    }
    @PostMapping("/resources")
    public List<?> detail(@RequestParam("accountId") int accountId,@RequestParam("way") String way){
        return resourcesService.detailByAccountId(way,accountId);
    }
    @PostMapping("/resources/{way}/{classify}")
    public List<?> detail(@RequestParam("accountId") int accountId,@PathVariable("way") String way,@PathVariable("classify") String classify){
        return resourcesService.resourceClassify(accountId,way,classify);
    }
}
