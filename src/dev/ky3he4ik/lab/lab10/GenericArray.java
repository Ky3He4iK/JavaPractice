package dev.ky3he4ik.lab.lab10;

public class GenericArray<T> {
    private Object[] array;

    GenericArray(int size) {
        array = new Object[size];
    }

    T get(int ind) {
        @SuppressWarnings("unchecked") final T obj = (T) array[ind];
        return obj;
    }

    void set(int ind, final T obj) {
        array[ind] = obj;
    }
}
