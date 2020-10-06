package dev.ky3he4ik.pr.pr11;

import java.util.HashMap;

public abstract class BinOperand implements Operand {
    protected Operand left;
    protected Operand right;

    public BinOperand(Operand left, Operand right) {
        this.left = left;
        this.right = right;
    }

    public double evaluate(double var) {
        return getResult((left == null) ? 0 : left.evaluate(var), (right == null) ? 0 : right.evaluate(var));
    }

    public double evaluate(HashMap<String, Integer> varMap) {
        return getResult((left == null) ? 0 : left.evaluate(varMap), (right == null) ? 0 : right.evaluate(varMap));
    }

    abstract double getResult(double a, double b);
}
