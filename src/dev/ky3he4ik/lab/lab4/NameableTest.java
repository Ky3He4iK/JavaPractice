package dev.ky3he4ik.lab.lab4;

public class NameableTest {
    public static void main(String[] args) {
        Nameable nameable = new Person();
        assert nameable.getName().equals("Vasya");
        nameable = new Planet();
        assert nameable.getName().equals("Pluto");
        System.out.println("Nameable tested successfully");
    }
}
