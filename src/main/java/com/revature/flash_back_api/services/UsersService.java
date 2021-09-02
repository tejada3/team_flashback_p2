package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.Users;
import com.revature.flash_back_api.models.repos.UsersRepository;
import com.revature.flash_back_api.util.exceptions.AuthenticationException;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.util.exceptions.ResourcePersistenceException;
import com.revature.flash_back_api.web.dtos.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepo;

    @Autowired
    UsersService(UsersRepository usersRepo){
        this.usersRepo = usersRepo;
    }

    public Users register(Users newUser) {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        if (usersRepo.findUserByUsername(newUser.getUsername()) != null) {
            throw new ResourcePersistenceException("Provided username is already taken!");
        }

        if (usersRepo.findUserByEmail(newUser.getEmail()) != null) {
            throw new ResourcePersistenceException("Provided username is already taken!");
        }


        newUser.setPassword(newUser.getPassword());

        return usersRepo.save(newUser);

    }

    //
    public Principal login(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid user credentials provided!");
        }

        Users authUser = usersRepo.findUserByCredentials(username, password);

        if (authUser == null) {
            throw new AuthenticationException("Invalid credentials provided!");
        }

        return new Principal(authUser);

    }


    public boolean isUserValid(Users user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        return user.getPassword() != null && !user.getPassword().trim().equals("");
    }
}
