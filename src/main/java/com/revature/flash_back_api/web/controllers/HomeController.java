package com.revature.flash_back_api.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {


    public String home(){
        return "Hello John, Charles, Jose and Sean!";
    }
}
