package com.revature.flash_back_api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {

    @Value("${encrypt.salt}")
    private String salt;

    public String generateSecurePassword(String password) {
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
    }
}
