package dev.ky3he4ik.lab.lab10;


import java.util.*;

import static java.lang.Math.min;

public class Solution {
    public static <T> List<T> toArray(T[] arr) {
        return Arrays.asList(arr);
    }

    public static <T> T getElem(T[] arr, int ind) {
        assert ind >= 0 && ind < arr.length;
        return arr[ind];
    }

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
}
