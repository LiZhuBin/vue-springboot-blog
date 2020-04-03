package com.springboot;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Var;
import org.junit.jupiter.api.Test;

import java.security.Key;

/**
 * @program: blog-back
 * @description:
 * @author: LiZhuBin
 * @create: 2020-04-04 01:30
 **/
@Log4j2
public class JwtTest {
    @Test
    public void generate(){

        String token="";
        token= JWT.create().withAudience("FF")
                .sign(Algorithm.HMAC256("GFF"));
        log.info(token);
    }
}
