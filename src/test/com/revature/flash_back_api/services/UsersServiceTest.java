package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.documents.User;
import com.revature.flash_back_api.models.repos.UsersRepository;
import com.revature.flash_back_api.util.exceptions.AuthenticationException;
import com.revature.flash_back_api.util.exceptions.InvalidRequestException;
import com.revature.flash_back_api.util.exceptions.ResourcePersistenceException;
import com.revature.flash_back_api.web.dtos.Principal;
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
    public void updateScore() {
        User user = new User("firstName", "lastName", "email@email.com", "username", "password");
        String username = "username";
        String score = "2";

        when(mockUserRepo.findUserByUsername(username)).thenReturn(user);

        sut.updateScore(username, score);

        verify(mockUserRepo, times(1)).save(user);

    }

    @Test
    void register_throwsException_givenInvalidUserData() {
        User user = null;
        boolean testResult = false;
        try{
            sut.register(user);
        } catch (InvalidRequestException ire) {
            testResult = true;
        }
        assertTrue(testResult);
    }

    @Test
    void register_throwsException_givenDuplicateUsername() {
        User user1 = new User("firstName", "lastName", "email@email.com", "username", "password");
        User user2 = new User("firstName", "lastName", "emailll@email.com", "username", "password");

        when(mockUserRepo.findUserByUsername(user1.getUsername())).thenReturn(user2);

        boolean testResult = false;
        try{
            sut.register(user1);
        } catch (ResourcePersistenceException ire) {
            testResult = true;
        }
        assertTrue(testResult);
    }

    @Test
    void register_throwsException_givenDuplicateEmail() {
        User user1 = new User("firstName", "lastName", "email@email.com", "username1", "password");
        User user2 = new User("firstName", "lastName", "email@email.com", "username2", "password");

        when(mockUserRepo.findUserByEmail(user1.getEmail())).thenReturn(user2);

        boolean testResult = false;
        try{
            sut.register(user1);
        } catch (ResourcePersistenceException ire) {
            testResult = true;
        }
        assertTrue(testResult);
    }

    @Test
    public void register_returnsSuccessfully_givenValidUserData() {
        User user = new User("firstName", "lastName", "email@email.com", "username", "password");

        sut.register(user);

        verify(mockUserRepo, times(1)).save(user);
    }

    @Test
    public void login_throwsException_givenNullUsernameAndPassword() {
        String username = null;
        String password = null;

        boolean testResult = false;

        try{
            sut.login(username, password);
        } catch (InvalidRequestException ire) {
            testResult = true;
        }
        assertTrue(testResult);
    }

    @Test
    public void login_throwsException_givenInvalidCredentials() {
        String username = "username";
        String password = "password";

        when(mockUserRepo.findUserByUsernameAndPassword(username, password)).thenReturn(null);

        boolean testResult = false;

        try {
            sut.login(username, password);
        } catch (AuthenticationException ae) {
            testResult = true;
        }

        assertTrue(testResult);
    }

    @Test
    public void login_returnsSuccessfully_givenValidUsernameAndPassword() {
        User user = new User("firstName", "lastName", "email@email.com", "username", "password");
        user.setId("1234");

        String username = "username";
        String password = "password";

        when(mockUserRepo.findUserByUsernameAndPassword(username, password)).thenReturn(user);

        try {
            sut.login(username, password);
        } catch (Exception e) {

        }

        verify(mockUserRepo, times(1)).findUserByUsernameAndPassword(username, password);
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