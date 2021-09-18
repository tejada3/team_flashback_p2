package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.TriviaCardSet;
import com.revature.flash_back_api.models.repos.TriviaCardSetsRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.util.exceptions.ResourcePersistenceException;
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
    public void updateSet_returnsSuccessfully_givenValidSet() {
        TriviaCardSet set = new TriviaCardSet("topic");

        sut.updateSet(set);

        verify(mockTCSRepo, times(1)).save(set);
    }

    @Test
    public void updateSet_throwsException_givenInvalidData() {
        TriviaCardSet set = new TriviaCardSet("");

        boolean testResult = false;

        try{
            sut.updateSet(set);
        } catch (InvalidRequestException ire) {
            testResult = true;
        }

        assertTrue(testResult);

    }

    @Test
    public void updateSet_throwsException_givenDuplicateTopic() {
        TriviaCardSet set1 = new TriviaCardSet("duplicate");
        TriviaCardSet set2 = new TriviaCardSet("duplicate");

        when(mockTCSRepo.findTriviaCardSetByTopic(set1.getTopic())).thenReturn(set2);

        boolean testResult = false;

        try{
            sut.updateSet(set1);
        } catch (ResourcePersistenceException rpe) {
            testResult = true;
        }

        assertTrue(testResult);

    }

    @Test
    public void createSet_returnsSuccessfully_givenValidData() {
        TriviaCardSet set = new TriviaCardSet("valid");

        sut.createSet(set);

        verify(mockTCSRepo, times(1)).save(set);
    }

    @Test
    public void createSet_throwsException_givenInvalidData() {
        TriviaCardSet set = new TriviaCardSet("");

        boolean testResult = false;

        try{
            sut.createSet(set);
        } catch (InvalidRequestException ire) {
            testResult = true;
        }

        assertTrue(testResult);
    }

    @Test
    public void createSet_throwsException_givenExistingTopic() {
        TriviaCardSet set1 = new TriviaCardSet("duplicate");
        TriviaCardSet set2 = new TriviaCardSet("duplicate");

        when(mockTCSRepo.findTriviaCardSetByTopic(set1.getTopic())).thenReturn(set2);

        boolean testResult = false;
        try{
            sut.createSet(set1);
        } catch (ResourcePersistenceException rpe) {
            testResult = true;
        }

        assertTrue(testResult);
    }

    @Test
    public void deleteSet() {
        TriviaCardSet set = new TriviaCardSet("topic");

        sut.deleteSet(set);

        verify(mockTCSRepo, times(1)).deleteTriviaCardSetById(any());
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