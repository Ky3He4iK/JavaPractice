package dev.ky3he4ik.pr.pr6;

import java.util.Random;

// 1
public class StudentSort {
    private Student[] iDNumber;
    private int size;

    public StudentSort(int size) {
        this.size = size;
        iDNumber = new Student[size];
        Random random = new Random();
        for (int i = 0; i < size; i++)
            iDNumber[i] = new Student(random.nextInt() & 0xfff);
    }

    public void sort() {
        for (int i = 1; i < size; i++) {
            Student key = iDNumber[i];
            int j = i - 1;
            while (j >= 0 && iDNumber[j].compare(key) > 0) {
                iDNumber[j + 1] = iDNumber[j];
                j--;
            }
            iDNumber[j + 1] = key;
        }
    }

    public void println() {
        for (int i = 0; i < size; i++)
            System.out.println(iDNumber[i].getScore());
    }

    public static void main(String[] args) {
        StudentSort studentSort = new StudentSort(10);
        System.out.println("Raw:");
        studentSort.println();
        studentSort.sort();
        System.out.println("\nSorted:");
        studentSort.println();
    }
}
