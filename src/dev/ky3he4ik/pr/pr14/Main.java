package dev.ky3he4ik.pr.pr14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Print your address in format: `Country[d] region[d] city[d] street[d] house[d] housing[d] flat[d]` where [d] is delimiter");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        Address addressA = Address.fromStringA(address);
        if (addressA == null)
            System.out.println("a) Wrong address (the only supported delimiter is `,`");
        else
            System.out.println("a) " + addressA);
        Address addressB = Address.fromStringB(address);
        if (addressB == null)
            System.out.println("b) Wrong address (the only supported delimiters is one of `,.;-`");
        else
            System.out.println("b) " + addressB);
    }
}
