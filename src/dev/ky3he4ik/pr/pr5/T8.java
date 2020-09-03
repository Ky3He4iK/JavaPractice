package dev.ky3he4ik.pr.pr5;

import java.util.Scanner;

public class T8 {
    private static boolean isPalindrom(String s, int shift) {
        if (shift >= s.length() / 2)
            return true;
        return s.charAt(shift) == s.charAt(s.length() - 1 - shift) && isPalindrom(s, shift + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPalindrom(scanner.nextLine(), 0) ? "YES" : "NO");
    }
}
