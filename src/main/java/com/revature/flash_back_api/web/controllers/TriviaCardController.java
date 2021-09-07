package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.models.repos.ThreadRepository;
import com.revature.flash_back_api.models.repos.TriviaCardRepository;
import com.revature.flash_back_api.services.TriviaCardService;
import com.revature.flash_back_api.web.dtos.TriviaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class TriviaCardController {
    //For creating new cards

    private TriviaCardService triviaCardService;

    public TriviaCardController(TriviaCardService triviaCardService){
        this.triviaCardService = triviaCardService;
    }



    @PostMapping("/trivia" )
    @ResponseStatus(HttpStatus.CREATED)
    public TriviaDTO createdNewCard(@RequestBody TriviaCard card) {
        return new TriviaDTO(triviaCardService.saveNewCard(card));

    }
}
