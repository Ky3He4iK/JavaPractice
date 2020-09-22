package dev.ky3he4ik.lab.lab5;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ShapeTest extends JPanel {
    private static final int N_FIGURES = 40;
    private ArrayList<Shape> shapes;

    ShapeTest() {
        shapes = new ArrayList<>(N_FIGURES);
        Random random = new Random();
        for (int i = 0; i < N_FIGURES; i++) {
            int side = random.nextInt(100) + 20;
            int x = random.nextInt(640);
            int y = random.nextInt(480);
            Color color = new Color(random.nextInt(), false);
            switch (random.nextInt(3)) {
                case 0:
                    shapes.add(new Circle(side, x, y, color));
                    break;
                case 1:
                    shapes.add(new Triangle(side, x, y, color));
                    break;
                case 2:
                    shapes.add(new Square(side, x, y, color));
                    break;
            }
        }
        setBackground(Color.BLACK);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        for (Shape shape : shapes)
            shape.draw(g);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShapeTest mainPanel = new ShapeTest();
                JFrame frame = new JFrame();
//                frame.setSize(640, 480);
                frame.setBackground(Color.BLACK);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
        new ShapeTest();
    }
}
