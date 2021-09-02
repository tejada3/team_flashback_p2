package com.revature.flash_back_api.models.util;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoClientFactory {

    private MongoClient mongoClient;

    @Value("${db.ipAddress}")
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
            CodecRegistry defaultCodecRegistry = getDefaultCodecRegistry();
            PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(defaultCodecRegistry, fromProviders(pojoCodecProvider));

            MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                                                            .applyToClusterSettings(builder -> builder.hosts(hosts))
                                                            .credential(credential)
                                                            .codecRegistry(pojoCodecRegistry)
                                                            .build();

            this.mongoClient = MongoClients.create(mongoClientSettings);

        } catch (Exception e) {
             //#TODO Update this exception to DataSourceException
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
