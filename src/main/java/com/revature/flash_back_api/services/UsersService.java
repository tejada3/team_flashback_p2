package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.User;
import com.revature.flash_back_api.models.repos.UsersRepository;
import com.revature.flash_back_api.util.exceptions.AuthenticationException;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.util.exceptions.ResourcePersistenceException;
import com.revature.flash_back_api.web.dtos.Principal;
import com.revature.flash_back_api.web.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    private final UsersRepository usersRepo;

    @Autowired
    UsersService(UsersRepository usersRepo){
        this.usersRepo = usersRepo;
    }



    public List<UserDTO> findAll(){

        return usersRepo.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public User register(User newUser) {

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        if (usersRepo.findUserByUsername(newUser.getUsername()) != null) {
            throw new ResourcePersistenceException("Provided username is already taken!");
        }

        if (usersRepo.findUserByEmail(newUser.getEmail()) != null) {
            throw new ResourcePersistenceException("Provided username is already taken!");
        }

        newUser.setRole("user");
        newUser.setPassword(newUser.getPassword());
        newUser.setUserId(newUser.getUserId());
        newUser.setRegistrationDateTime(LocalDateTime.now());

        return usersRepo.save(newUser);

    }


    public Principal login(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid user credentials provided!");
        }

        User authUser = usersRepo.findUserByUsernameAndPassword(username, password);

        if (authUser == null) {
            throw new AuthenticationException("Invalid credentials provided!");
        }

        return new Principal(authUser);

    }

    //#TODO implement own validation checking
    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        return user.getPassword() != null && !user.getPassword().trim().equals("");
    }

}
