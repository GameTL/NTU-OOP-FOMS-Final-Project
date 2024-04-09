package src;


import java.security.NoSuchAlgorithmException;

public class staff {

    private final byte[] passHash;


    public staff() throws NoSuchAlgorithmException {
        try {
            this.passHash = utils.getHash("password");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
