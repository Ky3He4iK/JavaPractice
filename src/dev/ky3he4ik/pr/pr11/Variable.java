package dev.ky3he4ik.pr.pr11;

import java.util.HashMap;

public class Variable extends Operand {
    String name;

    public Variable(String name) {
        super(null, null);
        this.name = name;
    }

    @Override
    protected double getResult(double a, double b, double var) {
        return var;
    }

    @Override
    protected double getResult(double a, double b, HashMap<String, Integer> varMap) {
        return varMap.get(name);
    }
}
