package src;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class utils {
    public static byte[] getHash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes());
        return hash;
    }
    // byte[] getHash("password") "password" ---> LADKSJFDKLSFJ890890230948lLSDKJFKLDSJ

    public class AuthenticationService {
        public static boolean login(String username, String password) {
            // Handle user login
            return true;
        }

        public static void changePassword(String username, String newPassword) {
            // Change user's password
        }
    }

}
