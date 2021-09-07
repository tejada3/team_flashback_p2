package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.TriviaCardSetsRepository;
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



}
