package dev.ky3he4ik.lab.lab5;

import java.awt.*;
import java.awt.geom.GeneralPath;

abstract public class Shape {
    protected int x;
    protected int y;
    protected Color color;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape() {
        x = 0;
        y = 0;
        color = Color.BLACK;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);

    protected void drawPath(Graphics g, double[] xPoints, double[] yPoints) {
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath figure = new GeneralPath();

        figure.moveTo(xPoints[0] + x, yPoints[0] + y);
        for (int i = 1; i < xPoints.length; i++)
            figure.lineTo(xPoints[i] + x, yPoints[i] + y);

        figure.closePath();

        g2d.setColor(Color.YELLOW);
        g2d.fill(figure);
    }
}
