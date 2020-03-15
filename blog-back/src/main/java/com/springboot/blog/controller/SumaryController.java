package com.springboot.blog.controller;

import com.springboot.blog.entity.db.AccountSumary;
import com.springboot.blog.service.AccountSumaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(value = "/v1/account-sumaries")
@ResponseBody
public class SumaryController {
    @Autowired
    AccountSumaryService accountSumaryService;
    @GetMapping("")
    public List<AccountSumary> allSumaries(){
        return accountSumaryService.findAll();
    }
    @PostMapping("")
    public Object byAccountId(@RequestParam("accountId") int accountId){
        return accountSumaryService.findAllByAccountId(accountId);
    }
}
