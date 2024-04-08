package src;
import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

public class staff {

    private final byte[] passHash;

    public byte[] getHash(String input) throws NoSuchAlgorithmException {
//        String input = "Hello, world!";

        // get an instance of the SHA-256 message digest algorithm
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // compute the hash of the input string
        byte[] hash = md.digest(input.getBytes());

        // convert the hash to a hexadecimal string
//        StringBuilder hexString = new StringBuilder();
//        for (byte b : hash) {
//            hexString.append(String.format("%02x", b));
//        }
//
//        // print the hash
//        System.out.println(hexString);

        return hash;
    }

    public staff() throws NoSuchAlgorithmException {
        try {
            this.passHash = getHash("password");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
