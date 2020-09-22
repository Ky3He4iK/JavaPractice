package dev.ky3he4ik.lab.lab5;

import java.awt.*;

public class Triangle extends Shape {
    protected int side;

    public Triangle(int side, int x, int y, Color color) {
        super(x, y, color);
        this.side = side;
    }

    public Triangle() {
    }

    public double getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {x, side + x, (side / 2 + x)};
        int[] yPoints = {(int) (side * 0.866 + y), (int) (side * 0.866 + y), y}; // sqrt(3)/2 = 0.8660...

        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }
}
