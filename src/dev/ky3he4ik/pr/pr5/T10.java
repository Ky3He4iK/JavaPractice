package dev.ky3he4ik.pr.pr5;

import java.util.Scanner;

public class T10 {
    private static int reverse(int n, int t) {
        if (n == 0)
            return t;
        return reverse(n / 10, t * 10 + n % 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(reverse(scanner.nextInt(), 0));
    }
}
