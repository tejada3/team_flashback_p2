package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.TriviaCardRepository;
import com.revature.flash_back_api.models.repos.TriviaCardSetsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
    void findAll() {
    }

    @Test
    void getCardsBySetId() {
    }

    @Test
    void saveNewCard() {
    }

    @Test
    void deleteCardById() {
    }

    @Test
    void deleteAllByTriviaCardSetId() {
    }

    @Test
    void isCardValid() {
    }
}