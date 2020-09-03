package dev.ky3he4ik.pr.pr5;

import java.util.Scanner;

public class T7 {

    private static void findMult(int n, int i) {
        if (i > n / 2) {
            System.out.println(n);
            return;
        }
        if (n % i == 0) {
            System.out.println(i);
            findMult(n / i, i);
        } else
            findMult(n, i + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        findMult(scanner.nextInt(), 2);
    }
}
