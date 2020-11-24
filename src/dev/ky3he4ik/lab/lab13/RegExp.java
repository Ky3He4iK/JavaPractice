package dev.ky3he4ik.lab.lab13;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegExp {
    public static boolean isGoodPassword(String s) {
        // some magic happened
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d_]{8,}&", s);
    }

    public static void main(String[] args) {
        System.out.println("Input text");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (isGoodPassword(s))
            System.out.println("It's a good password!");
        else
            System.out.println("You shouldn't use this as a password!");
    }
}
