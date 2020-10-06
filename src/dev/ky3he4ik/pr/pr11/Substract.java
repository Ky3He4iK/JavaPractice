package dev.ky3he4ik.pr.pr11;

public class Substract extends BinOperand {
    public Substract(BinOperand left, BinOperand right) {
        super(left, right);
    }

    @Override
    protected double getResult(double a, double b) {
        return a - b;
    }
}
