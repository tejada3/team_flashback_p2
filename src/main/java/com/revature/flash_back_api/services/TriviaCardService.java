package com.revature.flash_back_api.services;


import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.models.repos.TriviaCardRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriviaCardService {

    private final TriviaCardRepository triviaCardRepository;

    @Autowired
    TriviaCardService(TriviaCardRepository triviaCardRepository) {
        this.triviaCardRepository = triviaCardRepository;
    }


    public TriviaCard saveNewCard(TriviaCard newCard) {
        System.out.println(newCard);
        if (!isCardValid(newCard)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        System.out.println(newCard);
        return triviaCardRepository.save(newCard);

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

