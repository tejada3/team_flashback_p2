package com.revature.flash_back_api.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

@Component
public class PasswordUtils {

    @Value("${encrypt.salt}")
    private String salt;

    /**
     * The generateSecurePassword method fully encrypts a plaintext password via hash and Base64 encoding.
     * @param password - plaintext password to be encrypted.
     * @return = final encrypted password.
     */


    public String generateSecurePassword(String password) {
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        return Base64.getEncoder().encodeToString(securePassword);
    }

    /**
     * The hash method hashes the plaintext password as a byte array using the Salt value was a byte array.
     * @param password - plaintext password as a char array.
     * @param salt - the hash key in a byte array form.
     * @return - hashed password as a byte array.
     */
    private byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, 10000, 256);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
}
