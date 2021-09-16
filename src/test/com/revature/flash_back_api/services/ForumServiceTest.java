package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.SubforumRepository;
import com.revature.flash_back_api.models.repos.ThreadRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ForumServiceTest {

    ForumService sut;
    private SubforumRepository mockSubforumRepo;
    private ThreadRepository mockThreadRepo;
    private ThreadCommentService mockThreadCommentService;

    @BeforeEach
    void setUp() {
        mockSubforumRepo = mock(SubforumRepository.class);
        mockThreadCommentService = mock(ThreadCommentService.class);
        sut = new ForumService(mockSubforumRepo, mockThreadRepo, mockThreadCommentService);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    void findAllSubforums() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    void findAllThreads() {
    }

    @Test
    void saveNewThread() {
    }

    @Test
    void deleteOldThread() {
    }

    @Test
    void isThreadValid() {
    }

    @Test
    void saveNewSubforum() {
    }

    @Test
    void deleteOldSubforum() {
    }

    @Test
    void isSubforumValid() {
    }

    /* Example test for reference:
    @Test
    public void isUserValid_returnsFalseForGivenBlankValues() {

        // Arrange
        Student testStudent1 = new Student(null, 12562562, "firstname", "lastname", "email");
        Student testStudent2 = new Student("", 12562562, "firstname", "lastname", "email");
        Student testStudent3 = new Student("      ", 12562562, "firstname", "lastname", "email");

        // Act
        boolean actualResult1 = sut.isUserValid(testStudent1);
        boolean actualResult2 = sut.isUserValid(testStudent2);
        boolean actualResult3 = sut.isUserValid(testStudent3);

        // Assert
        Assert.assertFalse("The first name cannot be a null value!", actualResult1);
        Assert.assertFalse("The first name cannot be empty!", actualResult2);
        Assert.assertFalse("The first name cannot be empty space!", actualResult3);

    }
     */
}