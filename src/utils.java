package src;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class providing cryptographic functionalities and authentication services.
 * @author Game Limsila  Created at 26/3/24 Email : @author limsila.limsila@yahoo.com
 * @version 1.00.00
 */
public class utils {

    /**
     * Generates a SHA-256 hash for a given string.
     * This method is used for creating a secure hash of sensitive information like passwords.
     *
     * @param input The string to be hashed.
     * @return The byte array representing the SHA-256 hash of the input.
     * @throws NoSuchAlgorithmException If the SHA-256 digest algorithm is not available.
     */
    public static byte[] getHash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes());
        return hash;
    }

    /**
     * Inner class to handle authentication-related tasks such as login and password changes.
     */
    public static class AuthenticationService {

        /**
         * Attempts to authenticate a user with the provided username and password.
         * 
         * @param username The username of the user trying to log in.
         * @param password The password provided for login.
         * @return true if the username and password are correct and the user is authenticated successfully, false otherwise.
         */
        public static boolean login(String username, String password) {
            // Handle user login
            return true; // This would normally check user credentials against a stored value.
        }

        /**
         * Changes the password for a specified user.
         *
         * @param username The username of the user whose password is to be changed.
         * @param newPassword The new password that will replace the user's current password.
         */
        public static void changePassword(String username, String newPassword) {
            // Change user's password
            // This method would typically update the stored password hash with a new one generated from newPassword.
        }
    }

}
