package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.User;
import com.revature.flash_back_api.services.UsersService;
import com.revature.flash_back_api.web.dtos.Principal;
import com.revature.flash_back_api.web.dtos.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
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


    @GetMapping(produces = "application/json")
    public List<UserDTO> getAllUsers(){
        return usersService.findAll();

    }

}
