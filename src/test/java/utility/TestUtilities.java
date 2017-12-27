package utility;

import java.util.Random;

public class TestUtilities {

    static public StringBuffer generateMsg(byte msgLength) {
        Random random = new Random();
        String dict = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuffer res = new StringBuffer(msgLength);
        for (int i = 0; i < msgLength; i++) {
            res.append(dict.charAt(random.nextInt(dict.length()-1)));
        }
        return res;
    }
}
