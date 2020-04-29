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
//
//
//    /*Post*/
//    @PostMapping(value="users")
//    public ResponseEntity postUser(@RequestParam("id") Long id,
//                                   @RequestParam(value = "account",required = false) String account,
//                                   @RequestParam(value = "Nickname", required = false) String name ,
//                                   @RequestParam("password") String password,
//                                   @RequestParam(value = "avatar",required = false,defaultValue = "/用户.png") String avatar,
//                                   @RequestParam(value = "email",required = false) String email ){
//        if(userRepository.findById(id)!=null) return ResponseEntity.badRequest().body(new ApiResult<Object>(500,"user已存在",""));
//        User.UserBuilder userBuilder = new User.UserBuilder();
//        userBuilder.withId(id).withNickname(name).withPassword(password).withAccount(account).withEmail(email).withAvatar(avatar);
//
//        return ResponseEntity.accepted()