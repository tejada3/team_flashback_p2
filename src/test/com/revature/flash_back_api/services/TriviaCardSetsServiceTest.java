package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.TriviaCardSet;
import com.revature.flash_back_api.models.repos.TriviaCardSetsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        sut.findAll();

        verify(mockTCSRepo, times(1)).findAll();
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

    @Test
    public void isTriviaCardSetValid_returnsTrue_givenValidData(){
        TriviaCardSet set = new TriviaCardSet("topic");

        boolean testResult = sut.isTriviaCardSetValid(set);

        assertTrue(testResult);
    }

    @Test
    public void isTriviaCardSetValid_returnsFalse_givenNullOrBlankSetTopic(){
        TriviaCardSet set1 = null;
        TriviaCardSet set2 = new TriviaCardSet("");
        TriviaCardSet set3 = new TriviaCardSet("    ");

        boolean testResult1 = sut.isTriviaCardSetValid(set1);
        boolean testResult2 = sut.isTriviaCardSetValid(set2);
        boolean testResult3 = sut.isTriviaCardSetValid(set3);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
    }
}