package com.university.nerdtaxi.gameserver.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

// This Class convert the given password to hashed_password for storing in database and check the validation
public class Password {

    // Iteration count to iterating hashing process 12 times
    private static final int workload = 12;

    // Use to generate the hash representing a user password
    public static String hashPassword(String plaintextPassword) {
        String salt = BCrypt.gensalt(workload);
        String hashedPassword = BCrypt.hashpw(plaintextPassword, salt);
        return hashedPassword;
    }

    // Use to verify a computed hash from a plaintext password
    public static boolean checkPassword(String plaintextPassword, String storedHash) {
        if (storedHash == null || !storedHash.startsWith("$2a$"))
            throw new IllegalArgumentException("Invalid Hash");
        boolean passwordVerified = BCrypt.checkpw(plaintextPassword, storedHash);
        return passwordVerified;
    }
}
