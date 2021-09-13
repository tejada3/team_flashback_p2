package com.revature.flash_back_api.models.repos;

import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.models.documents.TriviaCardSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriviaCardRepository extends MongoRepository<TriviaCard, String>{
    TriviaCard findAllByTriviaCardSetId(String id);

    TriviaCard deleteAllByTriviaCardSetId(String triviaCardSetId);

    TriviaCard deleteTriviaCardById(String id);
}
