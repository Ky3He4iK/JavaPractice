package dev.ky3he4ik.pr.pr6;

public class Student {
    private int score;

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int compare(Student other) {
        return score - other.score;
    }
}
