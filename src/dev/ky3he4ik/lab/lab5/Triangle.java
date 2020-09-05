package dev.ky3he4ik.lab.lab5;

import java.awt.*;

public class Triangle extends Shape {
    protected double side;

    public Triangle(double side, double x, double y, Color color) {
        super(x, y, color);
        this.side = side;
    }

    public Triangle() {
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void draw(Graphics g) {
        double[] xPoints = {0, side, side / 2};
        double[] yPoints = {side * 0.866, side * 0.866, 0}; // sqrt(3)/2 = 0.8660...

        drawPath(g, xPoints, yPoints);
    }
}
