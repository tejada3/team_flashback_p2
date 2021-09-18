package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.TriviaCard;
import com.revature.flash_back_api.models.documents.TriviaCardSet;
import com.revature.flash_back_api.models.repos.TriviaCardRepository;
import com.revature.flash_back_api.models.repos.TriviaCardSetsRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TriviaCardServiceTest {

    TriviaCardService sut;
    private TriviaCardRepository mockTriviaCardRepo;
    private TriviaCardSetsRepository mockTriviaCardSetsRepo;

    @BeforeEach
    void setUp() {
        mockTriviaCardRepo = mock(TriviaCardRepository.class);
        mockTriviaCardSetsRepo = mock(TriviaCardSetsRepository.class);
        sut = new TriviaCardService(mockTriviaCardRepo, mockTriviaCardSetsRepo);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    public void findAll_returnsSuccessfully() {
        sut.findAll();

        verify(mockTriviaCardRepo, times(1)).findAll();
    }

    @Test
    void getCardsBySetId() {

        String setId = "valid";

        sut.getCardsBySetId(setId);

        verify(mockTriviaCardRepo, times(1)).findAllByTriviaCardSetId(anyString());

    }

    @Test
    public void updateCard_returnsSuccessfully_givenValidData() {
        List<String> ans = Arrays.asList("one", "two", "three", "four");
        TriviaCard card = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", ans);

        sut.updateCard(card);

        verify(mockTriviaCardRepo, times(1)).save(card);
    }

    @Test
    public void updateCard_throwsException_givenInvalidData() {
        TriviaCard card = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", null);
        boolean testResult = false;
        try{
            sut.updateCard(card);
        } catch (InvalidRequestException ire) {
            testResult = true;
        }
        assertTrue(testResult);
    }

    @Test
    public void saveNewCard_returnsSuccessfully_givenInvalidData() {
        List<String> ans = Arrays.asList("one", "two", "three", "four");
        TriviaCard card = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", ans);
        TriviaCardSet set = new TriviaCardSet("topic");

        when(mockTriviaCardSetsRepo.findTriviaCardSetById(any())).thenReturn(set);

        sut.saveNewCard(card);

        verify(mockTriviaCardRepo, times(1)).save(any(TriviaCard.class));
    }

    @Test
    public void saveNewCard_throwsException_givenValidData() {
        TriviaCard card = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", null);
        TriviaCardSet set = new TriviaCardSet("topic");
        boolean testResult = false;
        try{
            sut.saveNewCard(card);
        } catch (InvalidRequestException ire) {
            testResult = true;
        }
        assertTrue(testResult);
    }

    @Test
    public void deleteCardById_returns() {
        String id = "valid";
        List<String> ans = Arrays.asList("one", "two", "three", "four");
        TriviaCard card = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", ans);
        TriviaCardSet set = new TriviaCardSet("topic");

        when(mockTriviaCardRepo.deleteTriviaCardById(id)).thenReturn(card);
        when(mockTriviaCardSetsRepo.findTriviaCardSetById(card.getTriviaCardSetId())).thenReturn(set);

        sut.deleteCardById(id);

        verify(mockTriviaCardSetsRepo, times(1)).save(any());
    }

    @Test
    public void deleteAllByTriviaCardSetId() {
        String id = "valid";

        sut.deleteAllByTriviaCardSetId(id);

        verify(mockTriviaCardRepo, times(1)).deleteAllByTriviaCardSetId(any());

    }

    @Test
    public void isCardValid_returnsFalseIfCardIsNull() {
        TriviaCard card = null;

        boolean testResult = sut.isCardValid(card);

        assertFalse(testResult);
    }

    @Test
    public void isCardValid_returnsFalseIfQuestionIsNullOrBlank() {
        List<String> ans = Arrays.asList("one", "two", "three", "four");
        TriviaCard card1 = new TriviaCard("triviaCardSetId", null, "correctAnswer", "1", ans);
        TriviaCard card2 = new TriviaCard("triviaCardSetId", "", "correctAnswer", "1", ans);
        TriviaCard card3 = new TriviaCard("triviaCardSetId", "    ", "correctAnswer", "1", ans);

        boolean testResult1 = sut.isCardValid(card1);
        boolean testResult2 = sut.isCardValid(card2);
        boolean testResult3 = sut.isCardValid(card3);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
    }

    @Test
    public void isCardValid_returnsFalseIfCorrectAnswerIsNullOrBlank() {
        List<String> ans = Arrays.asList("one", "two", "three", "four");
        TriviaCard card1 = new TriviaCard("triviaCardSetId", "question", null, "1", ans);
        TriviaCard card2 = new TriviaCard("triviaCardSetId", "question", "", "1", ans);
        TriviaCard card3 = new TriviaCard("triviaCardSetId", "question", "    ", "1", ans);

        boolean testResult1 = sut.isCardValid(card1);
        boolean testResult2 = sut.isCardValid(card2);
        boolean testResult3 = sut.isCardValid(card3);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
    }

    @Test
    public void isCardValid_returnsFalseIfAnswersIfPointsNotNumberOrNegative() {
        List<String> ans = Arrays.asList("one", "two", "three", "four");
        TriviaCard card1 = new TriviaCard("triviaCardSetId", "question", "correctAnswer", null, ans);
        TriviaCard card2 = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "", ans);
        TriviaCard card3 = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "     ", ans);
        TriviaCard card4 = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "not number", ans);
        TriviaCard card5 = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "-1", ans);

        boolean testResult1 = sut.isCardValid(card1);
        boolean testResult2 = sut.isCardValid(card2);
        boolean testResult3 = sut.isCardValid(card3);
        boolean testResult4 = sut.isCardValid(card4);
        boolean testResult5 = sut.isCardValid(card5);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
        assertFalse(testResult4);
        assertFalse(testResult5);
    }

    @Test
    public void isCardValid_returnsFalseIfAnswersIsNullOrNotSizeFour() {
        List<String> ans1 = null;
        List<String> ans2 = Arrays.asList("one", "two", "three");
        List<String> ans3 = Arrays.asList("one", "two", "three", "four", "five");
        TriviaCard card1 = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", ans1);
        TriviaCard card2 = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", ans2);
        TriviaCard card3 = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", ans3);

        boolean testResult1 = sut.isCardValid(card1);
        boolean testResult2 = sut.isCardValid(card2);
        boolean testResult3 = sut.isCardValid(card3);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
    }

    @Test
    public void isCardValid_returnsTrueGivenValidInput() {
        List<String> ans = Arrays.asList("one", "two", "three", "four");
        TriviaCard card = new TriviaCard("triviaCardSetId", "question", "correctAnswer", "1", ans);

        boolean testResult = sut.isCardValid(card);

        assertTrue(testResult);
    }


}