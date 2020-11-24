package dev.ky3he4ik.pr.pr13;

public class Add extends BinOperand {
    public Add(Operand left, Operand right) {
        super(left, right);
    }

    @Override
    protected double getResult(double a, double b) {
        return a + b;
    }
}
