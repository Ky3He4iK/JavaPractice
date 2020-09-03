package dev.ky3he4ik.lab.lab5;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Square extends Shape {
    protected double side;

    public Square(double side, double x, double y, Color color) {
        super(x, y, color);
        this.side = side;
    }

    public Square() {
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void draw(Graphics g) {
        double[] xPoints = {0, side, side, 0};
        double[] yPoints = {0, 0, side, side};

        drawPath(g, xPoints, yPoints);
    }
}
