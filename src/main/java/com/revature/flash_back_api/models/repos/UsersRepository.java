package com.revature.flash_back_api.models.repos;

import com.revature.flash_back_api.models.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;

@Repository
public interface UsersRepository extends MongoRepository<User, User> {

    //#TODO finish writing queries

    User findUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
    User findUserByEmail(String email);




}
