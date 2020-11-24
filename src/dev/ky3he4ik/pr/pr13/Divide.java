package dev.ky3he4ik.pr.pr13;

public class Divide extends BinOperand {
    public Divide(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    protected double getResult(double a, double b) {
        return a / b;
    }
}
