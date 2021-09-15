package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.SubforumRepository;
import com.revature.flash_back_api.models.repos.ThreadRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class ForumServiceTestSuite {
    ForumService sut;
    private SubforumRepository mockSubforumRepo;
    private ThreadRepository mockThreadRepo;
    private ThreadCommentService mockThreadCommentService;

    @Before
    public void beforeEachTest() {
        mockSubforumRepo = mock(SubforumRepository.class);
        mockThreadCommentService = mock(ThreadCommentService.class);
        sut = new ForumService(mockSubforumRepo, mockThreadRepo, mockThreadCommentService);
    }

    @After
    public void afterEachTest() { sut = null;}

    // Repeat ad infinitum
    @Test
    public void exampleTest_beAsVerboseAsPossible() {
        // Arrange
        // Act
        // Assert
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
