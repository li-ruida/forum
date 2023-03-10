package com.lrdhappy.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages="com.lrdhappy.forum")
@MapperScan("com.lrdhappy.forum.mapper")
@ServletComponentScan(basePackages ="com.lrdhappy.forum")
@EnableCaching
public class ForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
        System.out.println("Start");
    }

}
