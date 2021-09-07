package com.revature.flash_back_api.models.repos;

import com.revature.flash_back_api.models.documents.TriviaCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriviaCardRepository extends MongoRepository<TriviaCard, String>{

}
