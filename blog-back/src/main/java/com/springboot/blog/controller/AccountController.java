package com.springboot.blog.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.manager.AccountViews;
import com.springboot.blog.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(value = "/v1/accounts")
@Api(value = "Swagger Test Control", description = "演示Swagger用法的Control类", tags = "Swagger Test Control Tag")
class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ArticleService articleService;

    @Autowired
    TokenService tokenService;


    int ArticleLine = 5;

    @ApiOperation(value = "得到用户数据",produces = "application/json")
    @RequestMapping(value = "{id}",method=RequestMethod.GET)
    @JsonView(AccountViews.OthersView.class)
    public JSONObject getAccountsById(@PathVariable(value = "id") int id) {
        JSONObject jsonObject = new JSONObject();
        JSONObject accountJson = new JSONObject();

        accountJson.put("newArticles",articleService.newArticles(id,ArticleLine));
        accountJson.put("hotArticles",articleService.hotArticles(id,ArticleLine));
        jsonObject.put("account",accountService.getAccountById(id));
        jsonObject.put("articles",accountJson);
        return jsonObject;
    }
//    @RequestMapping(value = "{id}",method=RequestMethod.GET)
//    public Account insertAccount()
    @RequestMapping(value = "{id}",method = RequestMethod.POST)
    public void update(@PathVariable(value = "id") int id,
                       @RequestParam(value = "name",required = false) String name,
                       @RequestParam(value = "site",required = false) String site,
                       @RequestParam(value = "company",required = false) String company,
                       @RequestParam(value = "sign",required = false) String sign
                       ){
        Account account = accountService.getAccountById(id).get();
        if(name!=null){
            account.setAccountName(name);
        }
        if(site!=null) account.setAccountSite(site);
        if(company!=null) account.setAccountCompany(company);
        if(sign!=null)  account.setAccountSign(sign);
        System.out.println(company);
        accountService.update(account);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteAccountsById(@PathVariable(value = "id") int id){

    }


    @PostMapping("actions/check")
    public Object login(@RequestParam(value = "accountName") String name,@RequestParam(value = "accountPassword") String password){
        JSONObject jsonObject=new JSONObject();
        Account userForBase=accountService.byName(name);
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


}
