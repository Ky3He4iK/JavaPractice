package dev.ky3he4ik.lab.lab7;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(7);
        assert !array.contains(1);
        assert array.contains(5);
        assert array.size() == 2;
        assert array.get(1) == 7;
        array.remove( Integer.valueOf(5));
        array.add(3);
        assert array.indexOf(3) == 1;
        System.out.println("ArrayList tested successfully");
    }
}
