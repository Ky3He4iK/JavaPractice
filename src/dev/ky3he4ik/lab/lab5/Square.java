package dev.ky3he4ik.lab.lab5;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Square extends Shape {
    protected int side;

    public Square(int side, int x, int y, Color color) {
        super(x, y, color);
        this.side = side;
    }

    public Square() {
    }

    public double getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {x, side + x, side + x, x};
        int[] yPoints = {y, y, side + y, side + y};

        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }
}
