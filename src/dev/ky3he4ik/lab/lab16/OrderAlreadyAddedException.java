package dev.ky3he4ik.lab.lab16;

public class OrderAlreadyAddedException extends IllegalAccessException {
    public OrderAlreadyAddedException(String s) {
        super(s);
    }
}
