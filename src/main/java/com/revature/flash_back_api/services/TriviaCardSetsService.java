package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.TriviaCardSet;
import com.revature.flash_back_api.models.repos.TriviaCardSetsRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.util.exceptions.ResourcePersistenceException;
import com.revature.flash_back_api.web.dtos.TriviaCardSetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriviaCardSetsService {

    private final TriviaCardSetsRepository triviaCardSetsRepo;

    @Autowired
    TriviaCardSetsService(TriviaCardSetsRepository triviaCardSetsRepo){
        this.triviaCardSetsRepo = triviaCardSetsRepo;
    }

    public List<TriviaCardSetDTO> findAll(){
        return triviaCardSetsRepo.findAll()
                                .stream()
                                .map(TriviaCardSetDTO::new)
                                .collect(Collectors.toList());
    }


    public TriviaCardSet createSet(TriviaCardSet newTriviaCardSet) {
        if(!isTriviaCardSetValid(newTriviaCardSet)) {
            throw new InvalidRequestException("Invalid Trivia Card Set data provided!");
        }
        if(triviaCardSetsRepo.findTriviaCardSetByTopic(newTriviaCardSet.getTopic()) != null) {
            throw new ResourcePersistenceException("Provided topic is already taken!");
        }
        newTriviaCardSet.setCardCount(0);
        return triviaCardSetsRepo.save(newTriviaCardSet);
    }

    public TriviaCardSet deleteSet(TriviaCardSet triviaCardSet){
        return triviaCardSetsRepo.deleteTriviaCardSetByTopic(triviaCardSet.getTopic());
    }

    private boolean isTriviaCardSetValid(TriviaCardSet newTriviaCardSet) {
        //TODO implement validation checking
        return true;
    }


}
