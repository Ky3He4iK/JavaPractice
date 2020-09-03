package dev.ky3he4ik.pr.pr5;

import java.util.Scanner;

public class T9 {
    private static int cntSeq(int a,  int b) {
        if (a > b + 1)
            return 0;
        if (a == 0 || b == 0)
            return 1;
        return cntSeq(a, b - 1) + cntSeq(a - 1, b - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(cntSeq(scanner.nextInt(), scanner.nextInt()));
    }
}
