package dev.ky3he4ik.pr.pr13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        double res = new Add(
                new Substract(
                        new Multiply(new Variable("x"), new Variable("x")),
                        new Multiply(new Const(2), new Variable("x"))),
                new Const(1)).evaluate(d);
        System.out.println("x^2 - 2x + 1 = " + res);
    }
}
