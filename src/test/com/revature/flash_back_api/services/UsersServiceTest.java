package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.User;
import com.revature.flash_back_api.models.repos.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsersServiceTest {

    UsersService sut;
    private UsersRepository mockUserRepo;

    @BeforeEach
    void setUp() {
        mockUserRepo = mock(UsersRepository.class);
        sut = new UsersService(mockUserRepo);
    }

    @AfterEach
    void tearDown() { sut = null; }

    @Test
    public void findAll() {
        sut.findAll();

        verify(mockUserRepo, times(1)).findAllByOrderByTotalScoreDesc();
    }

    @Test
    void register() {
    }

    @Test
    void login() {
    }

    @Test
    public void isUserValid_returnsFalse_givenNullUser() {
        User user = null;

        boolean testResult = sut.isUserValid(user);

        assertFalse(testResult);
    }

    @Test
    public void isUserValid_returnsFalse_givenNullOrBlankFirstName() {
        User user1 = new User(null, "lastName", "email@email.com", "username", "password");
        User user2 = new User("", "lastName", "email@email.com", "username", "password");
        User user3 = new User("    ", "lastName", "email@email.com", "username", "password");

        boolean testResult1 = sut.isUserValid(user1);
        boolean testResult2 = sut.isUserValid(user2);
        boolean testResult3 = sut.isUserValid(user3);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
    }

    @Test
    public void isUserValid_returnsFalse_givenNullOrBlankLastName() {
        User user1 = new User("firstName", null, "email@email.com", "username", "password");
        User user2 = new User("firstName", "", "email@email.com", "username", "password");
        User user3 = new User("firstName", "    ", "email@email.com", "username", "password");

        boolean testResult1 = sut.isUserValid(user1);
        boolean testResult2 = sut.isUserValid(user2);
        boolean testResult3 = sut.isUserValid(user3);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
    }

    @Test
    public void isUserValid_returnsFalse_givenNullOrBlankEmail() {
        User user1 = new User("firstName", "lastName", null, "username", "password");
        User user2 = new User("firstName", "lastName", "", "username", "password");
        User user3 = new User("firstName", "lastName", "     ", "username", "password");

        boolean testResult1 = sut.isUserValid(user1);
        boolean testResult2 = sut.isUserValid(user2);
        boolean testResult3 = sut.isUserValid(user3);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
    }

    @Test
    public void isUserValid_returnsFalse_givenInvalidUsername() {
        User user1 = new User("firstName", "lastName", "email@email.com", null, "password");
        User user2 = new User("firstName", "lastName", "email@email.com", "", "password");
        User user3 = new User("firstName", "lastName", "email@email.com", "    ", "password");
        User user4 = new User("firstName", "lastName", "email@email.com", "abcd", "password");

        boolean testResult1 = sut.isUserValid(user1);
        boolean testResult2 = sut.isUserValid(user2);
        boolean testResult3 = sut.isUserValid(user3);
        boolean testResult4 = sut.isUserValid(user4);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
        assertFalse(testResult4);
    }

    @Test
    public void isUserValid_returnsFalse_givenInvalidPassword() {
        User user1 = new User("firstName", "lastName", "email@email.com", "username", null);
        User user2 = new User("firstName", "lastName", "email@email.com", "username", "");
        User user3 = new User("firstName", "lastName", "email@email.com", "username", "    ");
        User user4 = new User("firstName", "lastName", "email@email.com", "username", "pass");

        boolean testResult1 = sut.isUserValid(user1);
        boolean testResult2 = sut.isUserValid(user2);
        boolean testResult3 = sut.isUserValid(user3);
        boolean testResult4 = sut.isUserValid(user4);

        assertFalse(testResult1);
        assertFalse(testResult2);
        assertFalse(testResult3);
        assertFalse(testResult4);
    }

    @Test
    public void isUserValid_returnsTrue_givenValidData() {
        User user = new User("firstName", "lastName", "email@email.com", "username", "password");

        boolean testResult = sut.isUserValid(user);

        assertTrue(testResult);
    }
}