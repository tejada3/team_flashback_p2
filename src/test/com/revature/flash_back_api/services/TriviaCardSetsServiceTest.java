package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.TriviaCardSetsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TriviaCardSetsServiceTest {

    TriviaCardSetsService sut;
    private TriviaCardSetsRepository mockTCSRepo;

    @BeforeEach
    void setUp() {
        mockTCSRepo = mock(TriviaCardSetsRepository.class);
        sut = new TriviaCardSetsService(mockTCSRepo);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    void findAll() {
    }

    @Test
    void createSet() {
    }

    @Test
    void deleteSet() {
    }

    @Test
    void updateSet() {
    }
}