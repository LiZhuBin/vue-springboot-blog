package com.springboot.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.blog.annotation.UserLoginToken;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.service.AccountService;
import com.springboot.blog.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-04 02:05
 **/
@RestController
@RequestMapping("/v1/api")
public class UserApi {
    @Autowired
    AccountService userService;
    @Autowired
    TokenService tokenService;
    //登录
    @PostMapping("/login")
    public Object login(@RequestParam(value = "name") String name,@RequestParam(value = "password") String password){
        JSONObject jsonObject=new JSONObject();
        Account userForBase=userService.byName(name);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getAccountPassword().equals(password)){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
