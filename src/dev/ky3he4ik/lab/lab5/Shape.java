package dev.ky3he4ik.lab.lab5;

import java.awt.*;
import java.awt.geom.GeneralPath;

abstract public class Shape {
    protected double x;
    protected double y;
    protected Color color;

    public Shape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape() {
        x = 0;
        y = 0;
        color = Color.BLACK;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
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
