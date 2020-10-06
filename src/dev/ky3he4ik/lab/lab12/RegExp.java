package dev.ky3he4ik.lab.lab12;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegExp {
    public static boolean isPlusAfterDigit(String s) {
        return Pattern.matches(".*\\d+ \\+.*", s);
    }

    public static boolean isGoodPassword(String s) {
        // some magic happened
        return Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_]{8,}", s);
    }

    public static void main(String[] args) {
        System.out.println("Input text");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (isPlusAfterDigit(s))
            System.out.println("There are a `+` after a number");
        else
            System.out.println("There are a no `+` after a number");
    }
}
