package dev.ky3he4ik.pr.pr11;

import java.util.HashMap;

public class Substract extends Operand {
    public Substract(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    protected double getResult(double a, double b, double var) {
        return a - b;
    }

    @Override
    protected double getResult(double a, double b, HashMap<String, Integer> varMap) {
        return a - b;
    }
}