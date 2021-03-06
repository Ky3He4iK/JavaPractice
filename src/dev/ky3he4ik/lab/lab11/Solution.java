package dev.ky3he4ik.lab.lab11;


import java.io.File;
import java.util.*;

import static java.lang.Math.min;

public class Solution {
    public static <T> ArrayList<T> newArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static <T> HashSet<T> newHashSet(T[] arr) {
        return new HashSet<>(Arrays.asList(arr));
    }

    public static <T, K> HashMap<T, K> newHashMap(T[] keys, K[] values) {
        assert keys.length == values.length;
        HashMap<T, K> map = new HashMap<>();
        for (int i = 0; i < min(keys.length, values.length); i++)
            map.put(keys[i], values[i]);
        return map;
    }

    public static List<String> directoryContent(String directory) {
        String[] contents = new File(directory).list();
        if (contents == null)
            return null;

        for (int i = 0; i < Integer.min(5, contents.length); i++)
            System.out.println(contents[i]);
        return Arrays.asList(contents);
    }

    public static void main(String[] args) {
        System.out.println(directoryContent("."));

        String[] strings = {"test", "asd", "dsa", "aaa"};
        Integer[] ints = {3, 4, 5, 6};
        System.out.println(newArrayList(strings));
        System.out.println(newHashSet(ints));
        System.out.println(newHashMap(ints, strings));

        System.out.println("Task done successfully!");
    }
}
