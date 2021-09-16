package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.Subforum;
import com.revature.flash_back_api.models.documents.Threads;
import com.revature.flash_back_api.models.repos.SubforumRepository;
import com.revature.flash_back_api.models.repos.ThreadRepository;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.web.dtos.ThreadDTO;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.omg.CORBA.DynAnyPackage.Invalid;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ForumServiceTest {

    ForumService sut;
    private SubforumRepository mockSubforumRepo;
    private ThreadRepository mockThreadRepo;
    private ThreadCommentService mockThreadCommentService;

    @BeforeEach
    void setUp() {
        mockSubforumRepo = mock(SubforumRepository.class);
        mockThreadRepo = mock(ThreadRepository.class);
        mockThreadCommentService = mock(ThreadCommentService.class);
        sut = new ForumService(mockSubforumRepo, mockThreadRepo, mockThreadCommentService);
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    void findAllSubforums() {
        // Act
        sut.findAllSubforums();

        // Assert
        verify(mockSubforumRepo, times(1)).findAll();
    }

    @Test
    void findAllThreads() {
        // Arrange
        String subforumId = "valid";

        // Act
        sut.findAllThreads(subforumId);

        // Assert
        verify(mockThreadRepo, times(1)).findBySubforumId(anyString());
    }

    @Test
    void saveNewThread() {
        // Arrange
        Threads newThread = new Threads("valid", "valid", "valid", "valid");

        // Act
        sut.saveNewThread(newThread);

        // Assert
        verify(mockThreadRepo, times(1)).save(any(Threads.class));
    }

    @Test
    void deleteOldThread() {
        // Arrange
        String threadId = "valid";
        when(mockThreadCommentService.deleteAllByThreadId(anyString())).thenReturn(true);

        // Act
        sut.deleteOldThread(threadId);

        // Assert
        verify(mockThreadCommentService, times(1)).deleteAllByThreadId(anyString());
        verify(mockThreadRepo, times(1)).deleteById(anyString());
    }

    @Test
    void isThreadValid() {
        // Arrange
        Threads validThread = new Threads("valid","valid","valid","valid");
        Threads badThread = new Threads("  ","  ","  ","  ");

        // Act
        boolean result1 = sut.isThreadValid(validThread);
        boolean result2 = sut.isThreadValid(badThread);

        // Assert
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void saveNewSubforum() {
    }

    @Test
    void deleteOldSubforum_GivenValidSubforumID() {
        // Arrange
        String subforumId = "valid";

        // Act
        sut.deleteOldSubforum(subforumId);

        // Assert
        verify(mockSubforumRepo, times(1)).deleteById(anyString());
    }

    @Test
    void doNot_deleteOldSubforum_GivenBadID() {
        // Arrange
        String subforumId = "";
        boolean caught = false;

        // Act
        try {
            sut.deleteOldSubforum(subforumId);
        } catch (InvalidRequestException ire) {
            caught = true;
        }

        // Assert
        verify(mockSubforumRepo, times(0)).deleteById(anyString());
        assertTrue(caught);
    }

    @Test
    void isSubforumValid() {
        // Arrange
        Subforum subforum = new Subforum("valid", 0);
        Subforum badSubforum = new Subforum("", 0);
        Subforum negaSubforum = new Subforum("Good Title", -2);

        // Act
        boolean testResult1 = sut.isSubforumValid(subforum);
        boolean testResult2 = sut.isSubforumValid(badSubforum);
        boolean testResult3 = sut.isSubforumValid(negaSubforum);

        // Assert
        assertTrue(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
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

    // Good testing example
    /*
    @Test(expected = ResourcePersistenceException.class)
    public void register_throwsException_whenGivenUserWithDuplicateUsername() {

        // Arrange
        AppUser existingUser = new AppUser("original", "original", "original", "duplicate", "original");
        AppUser duplicate = new AppUser("first", "last", "email", "duplicate", "password");
        when(mockUserRepo.findUserByUsername(duplicate.getUsername())).thenReturn(existingUser);

        // Act
        try {
            sut.register(duplicate);
        } finally {

            // Assert
            verify(mockUserRepo, times(1)).findUserByUsername(duplicate.getUsername());
            verify(mockUserRepo, times(0)).save(duplicate);
        }

    }
     */
}