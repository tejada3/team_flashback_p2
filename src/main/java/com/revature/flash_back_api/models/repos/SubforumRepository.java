package com.revature.flash_back_api.models.repos;

import com.revature.flash_back_api.models.documents.Subforum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubforumRepository extends MongoRepository<Subforum, String> {

}
