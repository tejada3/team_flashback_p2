package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.User;
import com.revature.flash_back_api.models.repos.UsersRepository;
import com.revature.flash_back_api.util.exceptions.AuthenticationException;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.util.exceptions.ResourceNotFoundException;
import com.revature.flash_back_api.util.exceptions.ResourcePersistenceException;
import com.revature.flash_back_api.web.dtos.Principal;
import com.revature.flash_back_api.web.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        return usersRepo.findAllByOrderByTotalScoreDesc()
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
            throw new ResourcePersistenceException("Provided email is already taken!");
        }

        newUser.setRole("user");
        newUser.setRegistrationDateTime(LocalDate.now());
        newUser.setPassword(newUser.getPassword());

        return usersRepo.save(newUser);
    }


    public User updateScore(String username, String score){
        User newUser = usersRepo.findUserByUsername(username);
        newUser.setTotalScore(newUser.getTotalScore() + Integer.parseInt(score));
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

        Principal newP = new Principal(authUser);
        newP.setId(authUser.getId());
        return newP;
    }

    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("") || user.getUsername().length() < 5) {
            return false;
        }
        if (user.getPassword() == null || user.getPassword().trim().equals("") || user.getPassword().length() < 5) {
            return false;
        }
        return true;
    }


    public User getUserByUsername(String username){

        try {
           User user = usersRepo.findUserByUsername(username);
           return user;
        }catch(Exception u){
            System.out.println(u.getMessage());
        }
        return null;
    }

}
