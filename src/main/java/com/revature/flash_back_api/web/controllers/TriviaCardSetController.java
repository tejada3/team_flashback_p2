package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.TriviaCardSet;
import com.revature.flash_back_api.services.TriviaCardSetsService;
import com.revature.flash_back_api.web.dtos.TriviaCardSetDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trivia")
public class TriviaCardSetController {

    private TriviaCardSetsService triviaCardSetsService;

    public TriviaCardSetController(TriviaCardSetsService triviaCardSetsService){
        this.triviaCardSetsService = triviaCardSetsService;
    }

    //for getting a list of all trivia card sets
    @GetMapping(produces = "application/json")
    public List<TriviaCardSetDTO> getAllUsers(){
        return triviaCardSetsService.findAll();
    }



}
