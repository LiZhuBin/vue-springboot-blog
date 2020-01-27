package com.springboot.blog.controller;

import com.springboot.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
public class LabelController  {
    @Autowired
    private LabelService labelService;
    @PostMapping("labels")
    public List<Map> getLabelsByArticleId(@RequestParam("way") String param, @RequestParam("id") int id){
        if(param.equals("article"))
            return labelService.getArticleLabels(id);
        else if (param.equals("account"))
            return labelService.getAccountLabels(id);
        return null;
    }




}
