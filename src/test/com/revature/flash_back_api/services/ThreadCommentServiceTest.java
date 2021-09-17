package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.ThreadCommentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void findAll() {
    }

    @Test
    void saveNewComment() {
    }

    @Test
    void deleteAllByThreadId() {
    }

    @Test
    void isCommentValid() {
    }

    @Test
    void deleteById() {
        // Arrange
        String id = "valid";

        // Act
        sut.deleteById(id);

        // Assert
        verify(mockThreadRepo, times(1)).deleteById(anyString());
    }
}