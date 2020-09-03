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
