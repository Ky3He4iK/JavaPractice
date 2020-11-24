package dev.ky3he4ik.pr.pr9;


import java.util.Arrays;
import java.util.Collection;

public class LabClassDriver {
    public static Student findByName(String name, Collection<Student> students) {
        for (Student student : students) {
            if (name.equals(student.getName())) {
                return student;
            }
        }
        return null;
    }

    public static void sort(Collection<Student> students) {
        Student[] objects = students.toArray(new Student[0]);
        sort(objects, 0, students.size() - 1);
        students.clear();
        students.addAll(Arrays.asList(objects));
    }

    public static void sort(Comparable<Student>[] objects) {
        sort(objects, 0, objects.length - 1);
    }

    private static void sort(Comparable<Student>[] objects, final int begin, final int end) {
        if (begin < end) {
            int part = partition(objects, begin, end);
            sort(objects, begin, part);
            sort(objects, part + 1, end);
        }
    }

    private static int partition(Comparable<Student>[] objects, final int begin, final int end) {
        final Comparable<Student> pivot = objects[(begin + end) / 2];
        int i = begin, j = end;
        while (true) {
            while (objects[i].compareTo((Student) pivot) > 0) {
                ++i;
            }
            while (objects[j].compareTo((Student) pivot) < 0) {
                --j;
            }

            if (i >= j) {
                return j;
            }
            Comparable<Student> temp = objects[i];
            objects[i] = objects[j];
            objects[j] = temp;
            ++i;
            --j;
        }
    }
}
