package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.models.documents.User;
import com.revature.flash_back_api.services.UsersService;
import com.revature.flash_back_api.web.dtos.Credentials;
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


    //for logging in
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Principal login(@RequestBody Credentials credentials) {
        return usersService.login(credentials.getUsername(), credentials.getPassword());
    }

    //For registering a new user
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@RequestBody User newUser) {
        return new UserDTO(usersService.register(newUser));

    }

    //for getting a list of all users
    @GetMapping(produces = "application/json", path = "/getAllUsers")
    public List<UserDTO> getAllUsers(){
        return usersService.findAll();
    }



    //updates Users Scores
    @ResponseStatus( HttpStatus.OK)
    @PutMapping(produces = "application/json", path ="/update-total")
    public UserDTO updateScore(@RequestParam String username, @RequestParam String score){
        System.out.println(username);
        System.out.println(score);
        return new UserDTO(usersService.updateScore(username , score));
    }


    @GetMapping(produces = "application/json", path = "/getUser")
    public UserDTO getUser(@RequestParam String u){
        return new UserDTO(usersService.getUserByUsername(u));
    }


}
