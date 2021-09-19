package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.ThreadComment;
import com.revature.flash_back_api.models.repos.ThreadCommentRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ThreadCommentServiceTest {

    ThreadCommentService sut;
    private ThreadCommentRepository mockThreadRepo;

    @BeforeEach
    void setUp() {
        mockThreadRepo = mock(ThreadCommentRepository.class);
        sut = new ThreadCommentService(mockThreadRepo);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    public void findAll() {
        String id = "valid";
        sut.findAll(id);
        verify(mockThreadRepo, times(1)).findByThreadId(id);
    }

    @Test
    void saveNewComment_throwsException_givenInvalidInput() {
        ThreadComment comment = null;

        boolean testResult = false;

        try{
            sut.saveNewComment(comment);
        } catch (InvalidRequestException ire) {
            testResult = true;
        }

        assertTrue(testResult);
    }

    @Test
    void saveNewComment_isSuccessful_givenValidData() {
        LocalDate date = LocalDate.of(2021, 9, 18);
        ThreadComment comment = new ThreadComment("threadId", "userId", "content", date);

        sut.saveNewComment(comment);

        verify(mockThreadRepo, times(1)).save(comment);

    }

    @Test
    void deleteAllByThreadId() {
        String id = "id";

        sut.deleteAllByThreadId(id);

        verify(mockThreadRepo, times(1)).deleteByThreadId(id);
    }

    @Test
    void isCommentValid_returnsFalse_givenNullOrBlankComment() {
        LocalDate date = LocalDate.of(2021, 9, 18);
        ThreadComment comment1 = null;
        ThreadComment comment2 = new ThreadComment("threadId", "userId", "", date);
        ThreadComment comment3 = new ThreadComment("threadId", "userId", "    ", date);

        boolean testResult1 = sut.isCommentValid(comment1);
        boolean testResult2 = sut.isCommentValid(comment2);
        boolean testResult3 = sut.isCommentValid(comment3);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
    }

    @Test
    void isCommentValid_returnsTrue_givenValidData() {
        LocalDate date = LocalDate.of(2021, 9, 18);
        ThreadComment comment = new ThreadComment("threadId", "userId", "content", date);

        boolean testResult = sut.isCommentValid(comment);

        assertTrue(testResult);
    }
}