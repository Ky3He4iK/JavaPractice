package dev.ky3he4ik.pr.pr5;

import java.util.Scanner;

public class T11 {
    private static int oneCount() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {
            n = in.nextInt();
            if (n == 0)
                return 0;
            else
                return oneCount() + (n == 1 ? 1 : 0);
        } else
            return oneCount() + (n == 1 ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(oneCount());
    }
}
//21
//12321
//3 5
//1234
//1 2 3 4 5 6 1 2 3 4 2 1 2 1 0 0