package dev.ky3he4ik.lab.lab10;


import java.io.File;
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
}
