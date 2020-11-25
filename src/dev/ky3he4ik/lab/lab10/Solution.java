package dev.ky3he4ik.lab.lab10;


import java.util.*;

public class Solution {
    public static <T> List<T> toArray(T[] arr) {
        return Arrays.asList(arr);
    }

    public static <T> T getElem(T[] arr, int ind) {
        assert ind >= 0 && ind < arr.length;
        return arr[ind];
    }

    public static void main(String[] args) {
        String[] strings = {"test", "asd", "gtrg"};
        List<String> strList = toArray(strings);
        Integer[] ints = {4, 6, 7, 8};
        List<Integer> intList = toArray(ints);

        GenericArray<String> array = new GenericArray<>(strings.length);
        for (int i = 0; i < strings.length; i++)
            array.set(i, strings[i]);
        GenericArray<Integer> arrayI = new GenericArray<>(ints.length);
        for (int i = 0; i < ints.length; i++)
            arrayI.set(i, ints[i]);

        assert getElem(strings, 2).equals(strings[2]);
        assert getElem(ints, 2).equals(ints[2]);

        System.out.println("Task done successfully!");
    }
}
