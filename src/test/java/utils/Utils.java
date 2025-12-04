package utils;

import java.util.Random;

public class Utils {

    public static String generateRandomEmail() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();
        while (email.length() < 10) { // length of the random string
            int index = (int) (rnd.nextFloat() * characters.length());
            email.append(characters.charAt(index));
        }
        return email.toString() + "@example.com";
    }
}
