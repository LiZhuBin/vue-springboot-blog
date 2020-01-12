package com.springboot.blog.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.springboot.blog.entity.db.Account;
import com.springboot.blog.manager.AccountViews;
import com.springboot.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping(value = "/v1")
@ResponseBody
class AccountController {
    @Autowired
    private AccountService accountService;


    @GetMapping("accounts")
    @JsonView(AccountViews.OthersView.class)
    public List<Account> getAllAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("accounts/{id}")
    @JsonView(AccountViews.OthersView.class)
    public Optional<Account> getAccountsById(@PathVariable(value = "id") int id) {

        return accountService.getAccountById(id);
    }

    @GetMapping("account/actions/check")
    @JsonView(AccountViews.SelfView.class)
    public Account checkAccount(@ModelAttribute Account mode) {

        return accountService.checkAccount(mode.getAccountName(), mode.getAccountPassword());
    }


    @GetMapping("test")

    @JsonView(AccountViews.BaseView.class)
    public List<Account> test() {
        return accountService.getAccounts();
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