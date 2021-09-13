package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.services.TriviaCardService;
import com.revature.flash_back_api.web.dtos.TriviaCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trivia/card")
public class TriviaCardController {
    //For creating new cards

    private TriviaCardService triviaCardService;

    public TriviaCardController(TriviaCardService triviaCardService){
        this.triviaCardService = triviaCardService;
    }

    @PostMapping("/create-trivia" )
    @ResponseStatus(HttpStatus.CREATED)
    public TriviaCardDTO createdNewCard(@RequestBody TriviaCard card) {
        return new TriviaCardDTO(triviaCardService.saveNewCard(card));
    }

    @GetMapping(produces = "application/json",path = "/getAllCards")
    public List<TriviaCardDTO> getAllTrivia(){
        return triviaCardService.findAll();
    }

    @DeleteMapping(produces = "application/json", path="/delete-card-byId")
    public TriviaCardDTO deleteCardById(@RequestParam String id) {
        return new TriviaCardDTO(triviaCardService.deleteCardById(id));
    }

    @DeleteMapping(produces = "application/json", path="/delete-card-bySetId")
    public TriviaCard deleteCardByTriviaCardSetId(@RequestParam String triviaCardSetId) {
        return triviaCardService.deleteAllByTriviaCardSetId(triviaCardSetId);
    }

}