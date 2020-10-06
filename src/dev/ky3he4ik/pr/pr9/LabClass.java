package dev.ky3he4ik.pr.pr9;


import java.util.Arrays;
import java.util.LinkedList;

public class LabClass {
    private final LinkedList<Student> students = new LinkedList<>();

    LabClass() {
        students.addAll(Arrays.asList(
                new Student("Abcd", "SQ4695", new byte[] {5, 5, 5, 5}),
                new Student("Efgh", "PH1357", new byte[] {5, 4, 5, 2}),
                new Student("Misha", "IT1228", new byte[] {5, 4, 3, 2}),
                new Student("Dima", "KB9847", new byte[] {5, 4, 4, 1}),
                new Student("Dmia", "IT1338", new byte[] {2, 2, 2, 5})
        ));
        new LabClassUI(this);
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public static void main(String[] args) {
        new LabClass();
    }
}
