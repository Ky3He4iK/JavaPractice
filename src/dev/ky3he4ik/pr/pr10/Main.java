package dev.ky3he4ik.pr.pr10;

public class Main {
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();
        System.out.println(factory.createComplex());
        System.out.println(factory.CreateComplex(4, 7));
    }
}
