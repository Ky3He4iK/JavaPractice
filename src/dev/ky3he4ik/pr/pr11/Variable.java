package dev.ky3he4ik.pr.pr11;

import java.util.HashMap;

public class Variable implements Operand {
    String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(double var) {
        return var;
    }

    @Override
    public double evaluate(HashMap<String, Integer> varMap) {
        return varMap.get(name);
    }
}
