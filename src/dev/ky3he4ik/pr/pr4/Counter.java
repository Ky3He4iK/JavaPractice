package dev.ky3he4ik.pr.pr4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// 4.1
public class Counter extends JFrame {
    private final String MILAN_STR = "AC Milan";
    private final String MADRID_STR = "Real Madrid";
    private final String DRAW_STR = "DRAW";
    private final String RESULT_STR_BASE = "Result: ";
    private final String LAST_SCORER_STR_BASE = "Last Scorer: ";
    private final String WINNER_STR_BASE = "Winner: ";

    private JLabel resultLbl;
    private JLabel lastScorerLbl;
    private JLabel winnerLbl;
    private int milanScore = 0;
    private int madridScore = 0;

    public Counter() {
        setLayout(new BorderLayout());

        JButton milanBtn = new JButton(MILAN_STR);
        milanBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                milanScore++;
                replaceStrings(MILAN_STR);
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
        JButton madridBtn = new JButton(MADRID_STR);
        madridBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                madridScore++;
                replaceStrings(MADRID_STR);
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
        resultLbl = new JLabel(RESULT_STR_BASE + milanScore + " X " + madridScore, SwingConstants.CENTER);
        lastScorerLbl = new JLabel(LAST_SCORER_STR_BASE + "N/A", SwingConstants.CENTER);
        winnerLbl = new JLabel(WINNER_STR_BASE + DRAW_STR, SwingConstants.CENTER);

        add(milanBtn, BorderLayout.WEST);
        add(madridBtn, BorderLayout.EAST);
        add(resultLbl, BorderLayout.CENTER);
        add(lastScorerLbl, BorderLayout.NORTH);
        add(winnerLbl, BorderLayout.SOUTH);

        setSize(640, 400);
        setVisible(true);
    }

    private void replaceStrings(String lastScorerName) {
        resultLbl.setText(RESULT_STR_BASE + milanScore + " X " + madridScore);
        lastScorerLbl.setText(LAST_SCORER_STR_BASE + lastScorerName);
        if (madridScore == milanScore)
            winnerLbl.setText(WINNER_STR_BASE + DRAW_STR);
        else
            winnerLbl.setText(WINNER_STR_BASE + ((madridScore > milanScore) ? MADRID_STR : MILAN_STR));
    }

    public static void main(String[] args) {
        new Counter();
    }
}
