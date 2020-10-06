package dev.ky3he4ik.pr.pr11;

import java.util.HashMap;

public class Const implements Operand {
    private double value;

    public Const(double value) {
        this.value = value;
    }
    @Override
    public double evaluate(double var) {
        return value;
    }

    @Override
    public double evaluate(HashMap<String, Integer> varMap) {
        return value;
    }
}
