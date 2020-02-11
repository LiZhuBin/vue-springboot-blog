package com.springboot.resources;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest()

@RunWith(SpringRunner.class)

class ResourceApplicationTests {
    Download download;
    String fileName = "1/images/526889.jpg";
    String domainOfBucket = "http://q47oxiycu.bkt.clouddn.com";
    String finalUrl = String.format("%s/%s", domainOfBucket, fileName);
    @Test
    void contextLoads() {
        download.downloadImage(finalUrl);
    }

}
