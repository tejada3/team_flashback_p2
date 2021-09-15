package com.revature.flash_back_api.models.repos;

import com.revature.flash_back_api.models.documents.TriviaCardSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriviaCardSetsRepository extends MongoRepository<TriviaCardSet, String>{

    TriviaCardSet findTriviaCardSetById(String id);
    TriviaCardSet findTriviaCardSetByTopic(String topic);

    void deleteTriviaCardSetById(String id);
}
