package dev.ky3he4ik.lab.lab2;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        assert c1.getRadius() == 0;
        c1.setRadius(14);
        assert c1.getRadius() == 14;
        c1 = new Circle(73.2);
        assert c1.getRadius() == 73.2;
        System.out.println("Circle tested successfully");
    }
}
