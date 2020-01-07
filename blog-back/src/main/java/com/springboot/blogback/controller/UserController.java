package com.springboot.blogback.controller;

import com.springboot.blogback.entity.ApiResult;
import com.springboot.blogback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1")

public class UserController {
    @Autowired
    private UserRepository userRepository;
    /*Get*/
    @GetMapping("users")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(new ApiResult<List<User>>(200,"success",userRepository.findAll()));
    }

    @GetMapping("users/{id}")
    public ResponseEntity getUsersById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(new ApiResult<Optional>(200,"success",userRepository.findById(id)));
    }


    /*Post*/
    @PostMapping(value="users")
    public ResponseEntity postUser(@RequestParam("id") Long id,
                         @RequestParam(value = "account",required = false) String account,
                         @RequestParam(value = "Nickname", required = false) String name ,
                         @RequestParam("password") String password,
                         @RequestParam(value = "avatar",required = false,defaultValue = "/用户.png") String avatar,
                         @RequestParam(value = "email",required = false) String email ){
        if(userRepository.findById(id)!=null) return ResponseEntity.badRequest().body(new ApiResult<Object>(500,"user已存在",""));
        User.UserBuilder userBuilder = new User.UserBuilder();
        userBuilder.withId(id).withNickname(name).withPassword(password).withAccount(account).withEmail(email).withAvatar(avatar);

        return ResponseEntity.accepted().body(new ApiResult<User>(200,"success",userRepository.save(userBuilder.build())));
    }
//    @PostMapping(value = "/post/user/actions/check-acount")
//

    /*put*/
    @PutMapping(value = "users/{id}")
    public ResponseEntity putUser(@RequestParam("id") Long id,
                         @RequestParam(value = "account",required = false) String account,
                         @RequestParam(value = "Nickname", required = false) String name ,
                         @RequestParam("password") String password,
                        @RequestParam(value = "avatar",required = false,defaultValue = "/用户.png") String avatar,
                         @RequestParam(value = "email",required = false) String email ){
        if(userRepository.findById(id)==null) return ResponseEntity.notFound().build();
        User.UserBuilder userBuilder = new User.UserBuilder();
        userBuilder.withId(id).withNickname(name).withPassword(password).withAccount(account).withEmail(email).withAvatar(avatar);
        return ResponseEntity.accepted().body(new ApiResult<User>(200,"success",userRepository.save(userBuilder.build())));

    }


    /*Put*/
//    @PutMapping(value = "/put/user")
//    public User putUser(@RequestParam("id") Long id,
//                                   @RequestParam(value = "account",required = false) String account,
//                                   @RequestParam(value = "Nickname", required = false) String name ,
//                                   @RequestParam("password") String password,
//                                   @RequestParam(value = "email",required = false) String email){
//        User.UserBuilder
//    }
    /*Delete*/
    @DeleteMapping(value = "users/{id}")
    public void delectUserById(@PathVariable(value = "id") Long id){
        userRepository.deleteById(id);
    }

}

