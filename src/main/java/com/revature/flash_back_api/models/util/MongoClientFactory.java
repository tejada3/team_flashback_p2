package com.revature.flash_back_api.models.util;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;

public class MongoClientFactory {

    private MongoClient mongoClient;

    @Value("${db.ipAddress}");
    private String ipAddress;

    @Value("${db.port}")
    private int port;

    @Value("db.dbName")
    private String dbName;

    @Value("db.username")
    private String username;

    @Value("#{'${db.password}'.toCharArray()}")
    private char[] password;

    @PostConstruct
    public void factoryConfig(){

        try{
            List<ServerAddress> hosts = Collections.singletonList(new ServerAddress(ipAddress, port));
            MongoCredential credential = MongoCredential.createScramSha1Credential(username, dbName, password);
            PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        } catch (Exception e) {
            throw new DataSourceException("An unexpected error has occurred", e)
        }
    }

    @PreDestroy
    public void cleanUp() {
        mongoClient.close();
    }

    public MongoClient getConnection(){
        return mongoClient;
    }
}
