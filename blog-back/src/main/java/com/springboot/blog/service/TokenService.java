package com.springboot.blog.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springboot.blog.entity.db.Account;
import org.springframework.stereotype.Service;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-04 02:06
 **/
@Service
public class TokenService {
    public String getToken(Account user) {
        String token="";
        token= JWT.create().withAudience(user.getAccountName())
                .sign(Algorithm.HMAC256(user.getAccountPassword()));
        return token;
    }
}
