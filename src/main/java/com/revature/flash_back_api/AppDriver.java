package com.revature.flash_back_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Implies ComponentScan, and some other stuff.
public class AppDriver {
    public static void main(String[] args) {
        SpringApplication.run(AppDriver.class, args);
    }
}
