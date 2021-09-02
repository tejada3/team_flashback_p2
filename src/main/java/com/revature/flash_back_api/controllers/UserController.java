package com.revature.flash_back_api.controllers;

import com.revature.flash_back_api.models.documents.User;
import com.revature.flash_back_api.services.UsersService;
import com.revature.flash_back_api.web.dtos.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Principal registerNewUser(@RequestBody User newUser) {
        return new Principal(usersService.register(newUser));

    }
}
