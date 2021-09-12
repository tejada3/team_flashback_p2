package com.revature.flash_back_api.services;


import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.models.repos.TriviaCardRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.web.dtos.TriviaCardSetDTO;
import com.revature.flash_back_api.web.dtos.TriviaCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriviaCardService {

    private final TriviaCardRepository triviaCardRepository;

    @Autowired
    TriviaCardService(TriviaCardRepository triviaCardRepository) {
        this.triviaCardRepository = triviaCardRepository;
    }

    public List<TriviaCardDTO> findAll(){
        return triviaCardRepository.findAll()
                .stream()
                .map(TriviaCardDTO::new)
                .collect(Collectors.toList());
    }


    public TriviaCard saveNewCard(TriviaCard newCard) {
        System.out.println(newCard);
        if (!isCardValid(newCard)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        System.out.println(newCard);
        return triviaCardRepository.save(newCard);
    }

    public TriviaCard deleteCardById(String id) {
        return triviaCardRepository.deleteTriviaCardById(id);
    }

    public String deleteCardByTriviaCardSetId(String triviaCardSetId) {
        for(TriviaCardDTO triviaCard : findAll()){
            if(triviaCard != null && triviaCard.getTriviaCardSetId() != null && triviaCard.getTriviaCardSetId().equals(triviaCardSetId)){
                deleteCardById(triviaCard.getId());
            }
        }
        return "Success";
    }



    //#TODO implement own validation checking
    public static boolean isCardValid(TriviaCard card) {
        System.out.println(card);
        if ((card == null) ||
                (card.getQuestion() == null || card.getQuestion().trim().equals("")) ||
                (card.getCorrectAnswer() == null || card.getCorrectAnswer().trim().equals("")) ||
                (card.getAnswers() == null)) {
            return false;
        } else {
            return true;
        }
    }
}

