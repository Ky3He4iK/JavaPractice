package dev.ky3he4ik.lab.lab5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ShapeTest extends JFrame {
    private ArrayList<Shape> shapes;

    ShapeTest() {
        shapes = new ArrayList<>(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    shapes.add(new Circle(random.nextInt(32), random.nextInt(640), random.nextInt(400), new Color(random.nextInt(), false)));
                    break;
                case 1:
                    shapes.add(new Triangle(random.nextInt(32), random.nextInt(640), random.nextInt(400), new Color(random.nextInt(), false)));
                    break;
                case 2:
                    shapes.add(new Square(random.nextInt(32), random.nextInt(640), random.nextInt(400), new Color(random.nextInt(), false)));
                    break;
            }
        }

        setSize(640, 400);
        setBackground(Color.BLACK);
        setVisible(true);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        for (Shape shape : shapes)
            shape.draw(g);
    }

    public static void main(String[] args) {
        new ShapeTest();
    }
}
