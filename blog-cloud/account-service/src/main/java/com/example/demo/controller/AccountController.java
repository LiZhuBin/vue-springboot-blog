package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: blog-cloud
 * @description:
 * @author: LiZhuBin
 * @create: 2020-03-24 01:41
 **/

@RestController
public class AccountController {
    /** 获取端口号 */
    @Value("${server.port}")
    String port;

    /**
     * 定义一个简单接口
     * @param name
     * @return
     */
    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name){
        return "hi " + name + ",I am from port :" + port;
    }
}
