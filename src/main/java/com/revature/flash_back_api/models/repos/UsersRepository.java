package com.revature.flash_back_api.models.repos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.revature.flash_back_api.models.documents.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {

    private final MongoCollection<Users> usersCollection;

    @Autowired
    public UsersRepository(MongoClient mongoClient) {
        this.usersCollection = mongoClient.getDatabase("p2").getCollection("users", Users.class);
    }

    public List<Users> findAll(){
        List<Users> users = new ArrayList<>();

        try {
            usersCollection.find().into(users);
        } catch (Exception e) {
          // #TODO throw appropriate exception
        }

        return users;
    }


}
