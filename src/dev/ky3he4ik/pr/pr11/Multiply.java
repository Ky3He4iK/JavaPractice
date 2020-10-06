package dev.ky3he4ik.pr.pr11;

public class Multiply extends BinOperand {
    public Multiply(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    protected double getResult(double a, double b) {
        return a * b;
    }
}
