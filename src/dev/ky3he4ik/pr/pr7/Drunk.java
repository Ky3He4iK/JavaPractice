package dev.ky3he4ik.pr.pr7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 2
public class Drunk {
    private Queue<Integer> firstPlayer;
    private Queue<Integer> secondPlayer;
    private String winner;
    private int turns;

    public Drunk(String p1Set, String p2Set) {
        Scanner scanner = new Scanner(p1Set);
        firstPlayer = new LinkedList<>();
        boolean[] a = new boolean[10];
        for (int i = 0; i < 5; i++) {
            int t = scanner.nextInt();
            if (t < 0 || t >= 10 || a[t]) {
                System.err.println("Invalid cards for first player!");
                System.exit(1);
            }
            a[t - 1] = true;
            firstPlayer.add(t);
        }
        scanner = new Scanner(p2Set);
        secondPlayer = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            int t = scanner.nextInt();
            if (t < 0 || t >= 10 || a[t]) {
                System.err.println("Invalid cards for second player!");
                System.exit(1);
            }
            a[t - 1] = true;
            secondPlayer.add(t);
        }
        turns = 0;
    }

    public void play() {
        while (turns <= 106 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            int p1card = firstPlayer.poll();
            int p2card = secondPlayer.poll();
            boolean p1won;
            if (p1card > p2card)
                p1won = !(p1card == 9 && p2card == 0);
             else
                p1won = p1card == 0 && p2card == 9;
            if (p1won) {
                firstPlayer.add(p1card);
                firstPlayer.add(p2card);
            } else {
                secondPlayer.add(p1card);
                secondPlayer.add(p2card);
            }

            turns++;
        }
        if (firstPlayer.isEmpty())
            winner = "second";
        else
            winner = "first";
    }

    public String getWinner() {
        return winner;
    }

    public int getTurns() {
        return turns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Drunk drunk = new Drunk(scanner.nextLine(), scanner.nextLine());
        drunk.play();
        if (drunk.getTurns() > 106)
            System.out.println("botva");
        else
            System.out.println(drunk.getWinner() + ' ' + drunk.getTurns());
    }
}
