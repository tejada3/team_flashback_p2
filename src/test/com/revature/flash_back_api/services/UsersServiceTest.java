package com.revature.flash_back_api.services;

import com.revature.flash_back_api.models.repos.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
    void findAll() {
    }

    @Test
    void register() {
    }

    @Test
    void login() {
    }

    @Test
    void isUserValid() {
    }
}