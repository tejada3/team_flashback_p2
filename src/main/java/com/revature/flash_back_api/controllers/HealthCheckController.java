package com.revature.flash_back_api.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping(produces = "application/json")
    public String health() {
        return "{\"status\": \"UP\"}";
    }
}
