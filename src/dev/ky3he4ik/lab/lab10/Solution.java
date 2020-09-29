package dev.ky3he4ik.lab.lab10;


import java.util.Arrays;
import java.util.List;

public class Solution {
    public static <T> List<T> toArray(T[] arr) {
        return Arrays.asList(arr);
    }

    public static <T> T getElem(T[] arr, int ind) {
        assert ind >= 0 && ind < arr.length;
        return arr[ind];
    }


}
