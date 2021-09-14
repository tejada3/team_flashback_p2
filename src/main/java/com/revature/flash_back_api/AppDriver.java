package com.revature.flash_back_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication // Implies ComponentScan, and some other stuff.
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableMongoRepositories(basePackages = "com.revature.flash_back_api.models.repos")

public class AppDriver {


    public static void main(String[] args) {



        SpringApplication.run(AppDriver.class, args);
    }
}



