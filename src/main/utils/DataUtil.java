package main.utils;

import java.util.Random;

public class DataUtil {

    public static String randomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String randomNumber(int length) {
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(numbers.charAt(rand.nextInt(numbers.length())));
        }
        return sb.toString();
    }
}
