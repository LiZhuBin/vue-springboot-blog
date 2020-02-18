package com.springboot.blog;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching

@EnableMongoRepositories
@EnableJpaRepositories
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 初始化转换器
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        // 初始化一个转换器配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //定义JSON格式
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
        // 将配置设置给转换器并添加到HttpMessageConverter转换器列表中
        fastConvert.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastConvert);
    }
}
