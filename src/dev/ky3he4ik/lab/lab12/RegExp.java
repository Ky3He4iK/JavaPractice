package dev.ky3he4ik.lab.lab12;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        System.out.println("Input text");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (Pattern.matches(".*\\d+ \\+.*", s))
            System.out.println("There are a `+` after a number");
        else
            System.out.println("There are a no `+` after a number");
    }
}
