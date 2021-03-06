package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.TriviaCardSet;
import com.revature.flash_back_api.services.TriviaCardService;
import com.revature.flash_back_api.services.TriviaCardSetsService;
import com.revature.flash_back_api.web.dtos.TriviaCardSetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trivia/set")
public class TriviaCardSetController {

    private TriviaCardSetsService triviaCardSetsService;
    private TriviaCardService triviaCardService;

    @Autowired
    public TriviaCardSetController(TriviaCardSetsService triviaCardSetsService, TriviaCardService triviaCardService){
        this.triviaCardSetsService = triviaCardSetsService;
        this.triviaCardService = triviaCardService;
    }

    //for getting a list of all trivia card sets
    @GetMapping(produces = "application/json", path = "/getAllSets")
    public List<TriviaCardSetDTO> getAllUsers(){
        return triviaCardSetsService.findAll();
    }

    //for creating a new Trivia Card Set
    @PostMapping("/create-set")
    @ResponseStatus(HttpStatus.CREATED)
    public TriviaCardSetDTO createSet(@RequestBody TriviaCardSet newTriviaCardSet){
        return new TriviaCardSetDTO(triviaCardSetsService.createSet(newTriviaCardSet));
    }

    //todo create successful deleteSet method
    //Todo this will take in a parameter not a body
    @DeleteMapping("/delete-set")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSet(@RequestBody TriviaCardSet triviaCardSet){
        triviaCardService.deleteAllByTriviaCardSetId(triviaCardSet.getId());
        triviaCardSetsService.deleteSet(triviaCardSet);
        return;
    }

    @PutMapping("/update-set")
    @ResponseStatus(HttpStatus.OK)
    public TriviaCardSetDTO updateSet(@RequestBody TriviaCardSet triviaCardSet){
        return new TriviaCardSetDTO(triviaCardSetsService.updateSet(triviaCardSet));
    }






}
