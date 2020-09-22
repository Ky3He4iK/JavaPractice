package dev.ky3he4ik.lab.lab5;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {
    protected int radius;

    public Circle(int radius, int x, int y, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    public Circle() {
        radius = 0;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, radius * 2, radius * 2);

        g2d.setColor(color);
        g2d.fill(circle);
    }
}
