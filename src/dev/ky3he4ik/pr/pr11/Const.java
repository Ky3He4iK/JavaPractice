package dev.ky3he4ik.pr.pr11;

import java.util.HashMap;

public class Const extends Operand {
    private double value;

    public Const(double value) {
        super(null, null);
        this.value = value;
    }

    @Override
    protected double getResult(double a, double b, double var) {
        return value;
    }

    @Override
    protected double getResult(double a, double b, HashMap<String, Integer> varMap) {
        return value;
    }
}
