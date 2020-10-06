package dev.ky3he4ik.pr.pr9;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String name) {
        super("Student with name `" + name + "` not found!");
    }
}