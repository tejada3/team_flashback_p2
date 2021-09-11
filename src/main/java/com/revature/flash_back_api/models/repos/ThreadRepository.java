package com.revature.flash_back_api.models.repos;

import com.revature.flash_back_api.models.documents.Threads;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadRepository extends MongoRepository<Threads, String> {
    //TODO finish this interface

    Threads findThreadsById(String id);
    List<Threads> findThreadsBySubforumId(String Subforumid);
    Threads findThreadsByThreadTitle(String title);


}
