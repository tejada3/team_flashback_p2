package com.revature.flash_back_api.services;


import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.models.documents.TriviaCardSet;
import com.revature.flash_back_api.models.repos.TriviaCardRepository;
import com.revature.flash_back_api.models.repos.TriviaCardSetsRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.web.dtos.TriviaCardSetDTO;
import com.revature.flash_back_api.web.dtos.TriviaCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriviaCardService {

    private final TriviaCardRepository triviaCardRepository;
    private final TriviaCardSetsRepository triviaCardSetsRepository;



    @Autowired
    TriviaCardService(TriviaCardRepository triviaCardRepository, TriviaCardSetsRepository triviaCardSetsRepository) {

        this.triviaCardRepository = triviaCardRepository;
        this.triviaCardSetsRepository = triviaCardSetsRepository;
    }

    public List<TriviaCardDTO> findAll(){
        return triviaCardRepository.findAll()
                .stream()
                .map(TriviaCardDTO::new)
                .collect(Collectors.toList());
    }


    public List<TriviaCardDTO> getCardsBySetId(String setId){
        System.out.println(triviaCardRepository.findAllByTriviaCardSetId(setId));
        return triviaCardRepository.findAllByTriviaCardSetId(setId)
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

        TriviaCardSet u = triviaCardSetsRepository.findTriviaCardSetById(newCard.getTriviaCardSetId());
        u.addCardCountByOne();
        System.out.println(u.getCardCount());
        triviaCardSetsRepository.save(u);
        return triviaCardRepository.save(newCard);
    }

    public TriviaCard deleteCardById(String id) {


        TriviaCard t = triviaCardRepository.deleteTriviaCardById(id);
        TriviaCardSet u = triviaCardSetsRepository.findTriviaCardSetById(t.getTriviaCardSetId());
        u.deleteCardCountByOne();
        triviaCardSetsRepository.save(u);
        return t;


    }

    public void deleteAllByTriviaCardSetId(String triviaCardSetId) {
        triviaCardRepository.deleteAllByTriviaCardSetId(triviaCardSetId);
        return;
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

