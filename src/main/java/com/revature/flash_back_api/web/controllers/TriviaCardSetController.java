package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.TriviaCardSet;
import com.revature.flash_back_api.services.TriviaCardSetsService;
import com.revature.flash_back_api.web.dtos.TriviaCardSetDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trivia/set")
public class TriviaCardSetController {

    private TriviaCardSetsService triviaCardSetsService;

    public TriviaCardSetController(TriviaCardSetsService triviaCardSetsService){
        this.triviaCardSetsService = triviaCardSetsService;
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
//    @DeleteMapping("/delete-set")
//    @ResponseStatus(HttpStatus.OK)
//    public TriviaCardSetDTO deleteSet(@RequestBody TriviaCardSet triviaCardSet){
//        return new TriviaCardSetDTO(triviaCardSetsService.deleteSet(triviaCardSet));
//    }





}
