package com.springboot.blog.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.Result;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.manager.AccountManager;
import com.springboot.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
class AccountController {
    @Autowired
    private AccountService accountService;

    @JsonView(AccountManager.Entity_1.class)
    @GetMapping("accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("accounts/{id}")

    public Result getAccountsById(@PathVariable(value = "id") int id) {
        return new Result<>(HttpStatus.OK.value(), "success", accountService.getAccountById(id));
    }
    @GetMapping("account/actions/check")

    public Result checkAccount(@ModelAttribute Account mode ){
        return new Result<>(HttpStatus.OK.value(),"success",accountService.checkAccount(mode.getAccountName(),mode.getAccountPassword()));
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