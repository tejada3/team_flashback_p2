package com.revature.flash_back_api.web.controllers;


import com.revature.flash_back_api.web.dtos.Principal;
import com.revature.flash_back_api.web.dtos.Credentials;
import com.revature.flash_back_api.services.UsersService;
import com.revature.flash_back_api.web.util.security.TokenGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsersService usersService;
    private final TokenGenerator tokenGenerator;

    public AuthController(UsersService usersService, TokenGenerator tokenGenerator){
        this.usersService = usersService;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Principal authenticate(@RequestBody @Valid Credentials credentials, HttpServletResponse resp){
        Principal principal = usersService.login(credentials.getUsername(), credentials.getPassword());
        resp.setHeader(tokenGenerator.getJwtHeader(), tokenGenerator.createToken(principal));
        return principal;
    }
}
