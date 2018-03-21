package bbsmt.bloqq.bloqq.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class UserUtils {

    public static String calcPasswordHash(String password) {
        StringBuffer result = new StringBuffer();
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try (Formatter f = new Formatter(result)) {
            for (byte b : md.digest()) {
                f.format("%02x", b);
            }
        }
        return result.toString();
    }

}
