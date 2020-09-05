package dev.ky3he4ik.lab.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.Random;

public class GuessGame extends JFrame {
    private final JFormattedTextField guessNum;
    private int realNum;
    private int triesLeft = 3;

    GuessGame() {
        setLayout(new FlowLayout());
        setTitle("Угадай число от 0 до 20 за 3 попытки");

        Random random = new Random();
        realNum = random.nextInt(20);
        guessNum = new JFormattedTextField(NumberFormat.getNumberInstance());
        guessNum.setValue(20);
        add(guessNum);
        JButton guessBtn = new JButton("Угадать!");
        guessBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    int n = Integer.parseInt(guessNum.getText());
                    if (n > 20 || n < 0) {
                        JOptionPane.showMessageDialog(null, "Вводить надо число от 0 до 20");
                        return;
                    }
                    triesLeft--;
                    String suff = triesLeft == 0 ? "\nПопытки кончились!" : "Осталось попыток: " + triesLeft;
                    if (n < realNum)
                        JOptionPane.showMessageDialog(null, "Искомое число больше. " + suff);
                    else if (n > realNum)
                        JOptionPane.showMessageDialog(null, "Искомое число меньше. " + suff);
                    else {
                        JOptionPane.showMessageDialog(null, "Правильно!");
                        dispose();
                    }
                    if (triesLeft <= 0) {
                        dispose();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
        add(guessBtn);

        setBackground(Color.BLACK);
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void dispose() {
        super.dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        new GuessGame();
    }
}
