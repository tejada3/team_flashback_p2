package com.revature.flash_back_api.web.controllers;

import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.web.dtos.TriviaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class TriviaCardController {
    //For creating new cards
    @PostMapping("/admintrivia")
    @ResponseStatus(HttpStatus.CREATED)
    public TriviaDTO saveNewCard(@RequestBody TriviaCard card) {
        return new TriviaDTO(TriviaCard.saveNewCard(card));

    }
}
