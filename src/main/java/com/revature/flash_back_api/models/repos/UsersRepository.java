package com.revature.flash_back_api.models.repos;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.revature.flash_back_api.models.documents.Users;
import com.revature.flash_back_api.util.exceptions.DataSourceException;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepository {

    private final MongoCollection<Users> usersCollection;

    @Autowired
    public UsersRepository(MongoClient mongoClient) {
        this.usersCollection = mongoClient.getDatabase("p2").getCollection("users", Users.class);

    }



    public  Users findUserByCredentials(String username, String encryptedPassword) {

        try {

            Document queryDoc = new Document("username", username).append("password", encryptedPassword);
            return usersCollection.find(queryDoc).first();

        } catch (Exception e) {
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }



    public Users findUserByUsername(String username) {

        try {
            return usersCollection.find(new Document("username", username)).first();
        } catch (Exception e) {
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }

    public Users findUserByEmail(String email) {

        try {
            return usersCollection.find(new Document("email", email)).first();
        } catch (Exception e) {
            throw new DataSourceException("An unexpected exception occurred.", e);
        }

    }


    public Users save(Users newUser) {


        try {

            newUser.setUserId(new ObjectId().toString());
            usersCollection.insertOne(newUser);

            return newUser;

        } catch (Exception e) {
            throw new DataSourceException("An unexpected exception occurred.", e);
        }
    }


}
