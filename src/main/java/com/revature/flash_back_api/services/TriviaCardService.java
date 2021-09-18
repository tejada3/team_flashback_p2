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
        return triviaCardRepository.findAllByTriviaCardSetId(setId)
                .stream()
                .map(TriviaCardDTO::new)
                .collect(Collectors.toList());
    }


    public TriviaCard saveNewCard(TriviaCard newCard) {
        if (!isCardValid(newCard)) {
            throw new InvalidRequestException("Invalid card data provided!");
        }

        TriviaCardSet u = triviaCardSetsRepository.findTriviaCardSetById(newCard.getTriviaCardSetId());
        u.addCardCountByOne();
        triviaCardSetsRepository.save(u);
        return triviaCardRepository.save(newCard);
    }

    public TriviaCard deleteCardById(String id) {
        TriviaCard t = triviaCardRepository.deleteTriviaCardById(id);
        TriviaCardSet u = triviaCardSetsRepository.findTriviaCardSetById(t.getTriviaCardSetId());
        if (u.getCardCount()!=0) {
            u.deleteCardCountByOne();
        }
        triviaCardSetsRepository.save(u);
        return t;
    }

    public void deleteAllByTriviaCardSetId(String triviaCardSetId) {
        triviaCardRepository.deleteAllByTriviaCardSetId(triviaCardSetId);
    }

    public TriviaCard updateCard(TriviaCard triviaCard){

        TriviaCard updatedCard = new TriviaCard();

        updatedCard.setId(triviaCard.getId());
        updatedCard.setTriviaCardSetId(triviaCard.getTriviaCardSetId());
        updatedCard.setQuestion(triviaCard.getQuestion());
        updatedCard.setCorrectAnswer(triviaCard.getCorrectAnswer());
        updatedCard.setAnswers(triviaCard.getAnswers());
        updatedCard.setPoints(triviaCard.getPoints());

        if(!isCardValid(updatedCard)){
            throw new InvalidRequestException("Invalid Trivia Card data provided");
        }

        return triviaCardRepository.save(updatedCard);

    }

    public boolean isCardValid(TriviaCard card) {
        if (card == null) return false;
        if (card.getQuestion() == null || card.getQuestion().trim().equals("")) return false;
        if (card.getCorrectAnswer() == null || card.getCorrectAnswer().trim().equals("")) return false;
        if (card.getAnswers() == null || card.getAnswers().size() != 4) {
            return false;
        }
        if (card.getPoints() == null || card.getPoints().trim().equals("")) return false;
        try{
            if (Integer.parseInt(card.getPoints()) < 0) return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

