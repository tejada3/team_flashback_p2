package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepo;

    @Autowired UsersService(UsersRepository usersRepo){
        this.usersRepo = usersRepo;
    }
}
